package com.nmattone.elevators.exceptions;

@SuppressWarnings("serial")
public class ElevatorNotFound extends Exception {

	private String elevatorId;
	
	public ElevatorNotFound(String elevatorId) {
		super();
		this.elevatorId = elevatorId;
	}

	public String getElevatorId() {
		return elevatorId;
	}

	public void setElevatorId(String elevatorId) {
		this.elevatorId = elevatorId;
	}
	
}
