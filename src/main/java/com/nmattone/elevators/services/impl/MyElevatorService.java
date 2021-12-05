package com.nmattone.elevators.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nmattone.elevators.exceptions.ElevatorNotFound;
import com.nmattone.elevators.exceptions.ValidationError;
import com.nmattone.elevators.model.Elevator;
import com.nmattone.elevators.model.ElevatorDirection;
import com.nmattone.elevators.services.ElevatorService;

/**
 *	Implementación que administra tres ascensores (generados por 'defecto' por el sistema).
 */
@Service
public class MyElevatorService implements ElevatorService {

	private Map<String,Elevator> elevators = null;
	
	@Override
	public List<Elevator> getElevators() {
		this.createDefaultElevators();
		return new ArrayList<>(elevators.values());
	}

	@Override
	public Elevator updateElevator(String id, ElevatorDirection direction, Integer currentFloor, Integer targetFloor) throws ElevatorNotFound, ValidationError {
		this.createDefaultElevators();
		if(this.elevators.containsKey(id)) {
			// Ejemplo de validación: dirección no puede ser nulo.
			// TODO: completar el resto de las validaciones (por ejemplo, piso actual debería ser un valor entre 1 y 20).
			if(direction == null) {
				throw new ValidationError("El campo 'direction' no puede ser nulo.");
			}
			Elevator elevator = this.elevators.get(id);
			elevator.setDirection(direction);
			elevator.setCurrentFloor(currentFloor);
			elevator.setTargetFloor(targetFloor);
			return elevator;
		} else {
			throw new ElevatorNotFound(id);
		}
	}
	
	/*
	 *	Inicializa el mapa ascensores con tres ascensores (A,B y C)
	 *	detenidos en el piso 1.
	 */
	private void createDefaultElevators() {
		if(this.elevators == null) {
			this.elevators = new HashMap<>();
			for(String name : Arrays.asList("A","B","C")) {
				Elevator elevator = new Elevator();
				elevator.setId(name);
				elevator.setDirection(ElevatorDirection.STOPPED);
				elevator.setCurrentFloor(1);
				elevator.setTargetFloor(null);
				elevators.put(elevator.getId(), elevator);
			}
		}
	}

}
