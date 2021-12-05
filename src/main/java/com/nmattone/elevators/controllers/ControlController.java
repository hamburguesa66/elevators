package com.nmattone.elevators.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nmattone.elevators.dto.ElevatorTO;
import com.nmattone.elevators.services.DispatcherService;
import com.nmattone.elevators.services.ElevatorService;

@RestController
@RequestMapping("control")
public class ControlController {

	@Autowired
	private DispatcherService dispatcher;
	
	@Autowired
	private ElevatorService elevatorService;
	
	@GetMapping("dispatch/{floor}")
	public ElevatorTO dispatchElevatorToFloor(@PathVariable("floor") Integer requestedFloor) {
		return new ElevatorTO(
				this.dispatcher.getElevatorToDispatch(
						this.elevatorService.getElevators(), requestedFloor));
	}
	
}
