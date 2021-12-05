package com.nmattone.elevators.dto;

import com.nmattone.elevators.model.Elevator;
import com.nmattone.elevators.model.ElevatorDirection;

public class ElevatorTO {

	private String id;
	private ElevatorDirection direction;
	private Integer currentFloor;
	private Integer targetFloor;
	
	public ElevatorTO() {
		
	}
	
	public ElevatorTO(Elevator data) {
		this.id = data.getId();
		this.direction = data.getDirection();
		this.currentFloor = data.getCurrentFloor();
		this.targetFloor = data.getTargetFloor();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ElevatorDirection getDirection() {
		return direction;
	}

	public void setDirection(ElevatorDirection direction) {
		this.direction = direction;
	}

	public Integer getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(Integer currentFloor) {
		this.currentFloor = currentFloor;
	}

	public Integer getTargetFloor() {
		return targetFloor;
	}

	public void setTargetFloor(Integer targetFloor) {
		this.targetFloor = targetFloor;
	}
	
}
