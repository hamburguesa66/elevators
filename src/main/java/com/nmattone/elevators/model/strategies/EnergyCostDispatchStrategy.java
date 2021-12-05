package com.nmattone.elevators.model.strategies;

import com.nmattone.elevators.model.ElevatorDirection;
import com.nmattone.elevators.model.ElevatorStatus;

/**
 *	Estrategia que calcula el costo de energia que tiene un ascensor para responder un llamado.
 */
public class EnergyCostDispatchStrategy implements ElevatorDispatchCostStrategy {

	@Override
	public Integer execute(ElevatorStatus status, Integer requestedFloor) {
		if(status.getDirection().equals(ElevatorDirection.STOPPED)) {
			return Math.abs(status.getCurrentFloor() - requestedFloor);
		} else {
			if(this.floorIsBetweenPath(status, requestedFloor)) {
				return 0;
			} else {
				return Math.abs(status.getTargetFloor() - requestedFloor);
			}
		}
	}
	
	/*
	 *	Recibe el estado de un ascensor y un piso y retorna si ese piso le queda "de pasada"
	 *	(o técnicmente, entre el piso actual del ascensor y al qué se está dirigiendo).
	 */
	private boolean floorIsBetweenPath(ElevatorStatus status, Integer floor) {
		Integer currentFloor = status.getCurrentFloor();
		Integer targetFloor = status.getTargetFloor();
		switch (status.getDirection()) {
			case MOVING_DOWN:			
				return floor >= targetFloor && floor <= currentFloor;
			case MOVING_UP:
				return floor >= currentFloor && floor <= targetFloor;
			default:
				return false;
		}
	}

}
