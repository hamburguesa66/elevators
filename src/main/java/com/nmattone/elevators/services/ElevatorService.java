package com.nmattone.elevators.services;

import java.util.List;

import com.nmattone.elevators.exceptions.ElevatorNotFound;
import com.nmattone.elevators.exceptions.ValidationError;
import com.nmattone.elevators.model.Elevator;
import com.nmattone.elevators.model.ElevatorDirection;

/**
 *	Servicio que administra los ascensores.
 */
public interface ElevatorService {

	/**
	 * 
	 * @return la lista de ascensores (Elevator) del sistema
	 */
	public List<Elevator> getElevators();
	
	/**
	 * Actualiza el ascensor con el ID recibido como parámetro.
	 * Sólo se actualiza la dirección, el piso actual y el destino.
	 * 
	 * @param id
	 * @param direction
	 * @param currentFloor
	 * @param targetFloor
	 * @return el ascensor (Elevator) actualizado
	 * @throws ElevatorNotFound si el ID no pertenece a ningún ascensor
	 * @throws ValidationError si alguno de los parámetros no son válidos
	 */
	public Elevator updateElevator(String id, ElevatorDirection direction, Integer currentFloor, Integer targetFloor) throws ElevatorNotFound, ValidationError;
	
}
