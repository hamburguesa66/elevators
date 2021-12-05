package com.nmattone.elevators.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nmattone.elevators.model.Elevator;
import com.nmattone.elevators.model.strategies.ElevatorDispatchCostStrategy;
import com.nmattone.elevators.services.DispatcherService;

/**
 *	Asignador de ascensores que siempre toma el ascensor que pueda atener el llamado con
 *	el menor costo.
 */
@Service
public class MinCostDispatcherService implements DispatcherService {

	private ElevatorDispatchCostStrategy strategy;
	
	@Override
	public Elevator getElevatorToDispatch(List<Elevator> elevators, Integer requestedFloor) {
		Elevator bestElevator = null;
		Integer minCost = Integer.MAX_VALUE;
		for(Elevator elevator : elevators) {
			Integer cost = this.strategy.execute(elevator.getCurrentStatus(), requestedFloor);
			if(cost < minCost) {
				minCost = cost;
				bestElevator = elevator;
			}
		}
		return bestElevator;
	}

	@Override
	public void setStrategy(ElevatorDispatchCostStrategy strategy) {
		this.strategy = strategy;
	}
	
}
