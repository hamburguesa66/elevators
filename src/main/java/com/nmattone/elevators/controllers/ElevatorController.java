package com.nmattone.elevators.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nmattone.elevators.dto.ElevatorTO;
import com.nmattone.elevators.exceptions.ElevatorNotFound;
import com.nmattone.elevators.exceptions.ValidationError;
import com.nmattone.elevators.services.ElevatorService;

@RestController
@RequestMapping("elevators")
public class ElevatorController {

	@Autowired
	private ElevatorService elevatorService;
	
	@GetMapping
	public List<ElevatorTO> getElevators() {
		return this.elevatorService.getElevators().stream()
				.map(ElevatorTO::new)
				.collect(Collectors.toList());
	}
	
	@PostMapping
	public ElevatorTO updateElevator(@RequestBody ElevatorTO elevator) throws ElevatorNotFound, ValidationError {
		return new ElevatorTO(this.elevatorService.updateElevator(
				elevator.getId(), 
				elevator.getDirection(), 
				elevator.getCurrentFloor(), 
				elevator.getTargetFloor()));
	}
	
}
