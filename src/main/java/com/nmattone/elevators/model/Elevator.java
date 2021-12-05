package com.nmattone.elevators.model;

public class Elevator {

	private String id;
	private ElevatorDirection direction;
	private Integer currentFloor;
	private Integer targetFloor;
	private Integer currentCapacity;
	private Integer maxCapacity;
	private boolean doorOpen;
	private Long currentSpeed;
	private Long maxSpeed;
	
	public Elevator() {
		
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

	public Integer getCurrentCapacity() {
		return currentCapacity;
	}

	public void setCurrentCapacity(Integer currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	public Integer getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public boolean isDoorOpen() {
		return doorOpen;
	}

	public void setDoorOpen(boolean doorOpen) {
		this.doorOpen = doorOpen;
	}

	public Long getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(Long currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public Long getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(Long maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	/**
	 * 
	 */
	public void moveUp() {
		
	}
	
	/**
	 * 
	 */
	public void moveDown() {
		
	}
	
	/**
	 * 
	 */
	public void selectFloor() {
		
	}
	
	/**
	 * 
	 */
	public void openDoor() {
		
	}
	
	/**
	 *
	 */
	public ElevatorStatus getCurrentStatus() {
		ElevatorStatus status = new ElevatorStatus();
		status.setCurrentFloor(this.currentFloor);
		status.setDirection(this.direction);
		status.setTargetFloor(this.targetFloor);
		return status;
	}
	
}
