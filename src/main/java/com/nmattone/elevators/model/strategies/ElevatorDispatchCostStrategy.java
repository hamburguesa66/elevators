package com.nmattone.elevators.model.strategies;

import com.nmattone.elevators.model.ElevatorStatus;

public interface ElevatorDispatchCostStrategy {

	/**
	 * Calcula el cost que tiene un ascensor de atender un llmado.
	 * 
	 * @param status
	 * @param requestedFloor
	 * @return el costo de atender el llamado (Integer)
	 */
	public Integer execute(ElevatorStatus status, Integer requestedFloor);
	
}
