package com.nmattone.elevators.model;

import java.util.Date;

public class ElevatorStatus {

	private Date timestamp;
	private ElevatorDirection direction;
	private Integer currentFloor;
	private Integer targetFloor;
	
	public ElevatorStatus() {
		this.timestamp = new Date();
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
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
