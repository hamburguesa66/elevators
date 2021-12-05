package com.nmattone.elevators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.nmattone.elevators.model.Elevator;
import com.nmattone.elevators.model.ElevatorDirection;
import com.nmattone.elevators.model.strategies.EnergyCostDispatchStrategy;
import com.nmattone.elevators.services.DispatcherService;
import com.nmattone.elevators.services.impl.MinCostDispatcherService;

@SpringBootTest
class ElevatorsApplicationTests {

	private Elevator elevatorA;
	private Elevator elevatorB;
	private Elevator elevatorC;
	private DispatcherService dispatcher;
	private List<Elevator> elevators;
	
	/*
	 *	Inicializa las variables utilizadas por todos los tests.
	 */
	@BeforeEach
	public void init() {
		this.elevatorA = this.createEmptyElevator("A");
		this.elevatorB = this.createEmptyElevator("B");
		this.elevatorC = this.createEmptyElevator("C");
		this.dispatcher = new MinCostDispatcherService();
		this.dispatcher.setStrategy(new EnergyCostDispatchStrategy());
		this.elevators = Arrays.asList(this.elevatorA, this.elevatorB, this.elevatorC);
	}
	
	@Test
	public void closestStoppedElevatorTest() {
		this.setStatusOfElevator(this.elevatorA, ElevatorDirection.STOPPED, 7, null);
		this.setStatusOfElevator(this.elevatorB, ElevatorDirection.STOPPED, 12, null);
		this.setStatusOfElevator(this.elevatorC, ElevatorDirection.STOPPED, 1, null);
		assertEquals(this.dispatcher.getElevatorToDispatch(this.elevators, 8), this.elevatorA);
	}
	
	@Test
	public void floorIsBetweenPathTest() {
		this.setStatusOfElevator(this.elevatorA, ElevatorDirection.STOPPED, 1, null);
		this.setStatusOfElevator(this.elevatorB, ElevatorDirection.STOPPED, 1, null);
		this.setStatusOfElevator(this.elevatorC, ElevatorDirection.MOVING_DOWN, 20, 9);
		assertEquals(this.dispatcher.getElevatorToDispatch(this.elevators, 10), this.elevatorC);
	}
	
	@Test
	public void closesElevatorIsInOppositeDirectionTest() {
		this.setStatusOfElevator(this.elevatorA, ElevatorDirection.STOPPED, 1, null);
		this.setStatusOfElevator(this.elevatorB, ElevatorDirection.MOVING_UP, 16, 18);
		this.setStatusOfElevator(this.elevatorC, ElevatorDirection.STOPPED, 1, null);
		assertEquals(this.dispatcher.getElevatorToDispatch(this.elevators, 10), this.elevatorB);
	}
	
	/*
	 *	Crea un ascesor (detenido en el piso 1) con el ID recibido como parámetro.
	 */
	private Elevator createEmptyElevator(String id) {
		Elevator elevator = new Elevator();
		elevator.setId(id);
		elevator.setCurrentFloor(1);
		elevator.setDirection(ElevatorDirection.STOPPED);
		elevator.setTargetFloor(null);
		return elevator;
	}
	
	/*
	 *	Actualiza la dirección, el piso actual y el destino del ascesor recibido como parámetro.
	 */
	private void setStatusOfElevator(Elevator elevator, ElevatorDirection direction, Integer currentFloor, Integer targetFloor) {
		elevator.setDirection(direction);
		elevator.setCurrentFloor(currentFloor);
		elevator.setTargetFloor(targetFloor);
	}

}
