package com.nmattone.elevators.services;

import java.util.List;

import com.nmattone.elevators.model.Elevator;
import com.nmattone.elevators.model.strategies.ElevatorDispatchCostStrategy;

/**
 *	Servicio que se encarga de asignar los ascensores a los llamados de cada piso.
 */
public interface DispatcherService {

	/**
	 * Recibe una lista de ascensores y calcula cuál de ellos debería atender el llamado
	 * en base a un costo determinado (que puede energia, tiempo, etc).
	 * 
	 * @param elevators
	 * @param requestedFloor
	 * @return el ascensor (Elevator) que debería atender el llamado
	 */
	public Elevator getElevatorToDispatch(List<Elevator> elevators, Integer requestedFloor);
	
	/**
	 * Setea la estrategia para calcular el costo de atender un llamado.
	 * @param strategy
	 */
	public void setStrategy(ElevatorDispatchCostStrategy strategy);
	
}
