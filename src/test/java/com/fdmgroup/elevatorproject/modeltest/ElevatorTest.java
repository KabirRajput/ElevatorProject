package com.fdmgroup.elevatorproject.modeltest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fdmgroup.elevatorproject.model.*;

public class ElevatorTest {
	
	@Test
	public void given_Elevator_From_0_To_1_when_getCurrentFloor_returns1() {
		
		int floorTarget = 1;
		Elevator elevator = new Elevator();
		
		elevator.go(floorTarget);
		
		int result = elevator.getCurrentFloor();		
		assertEquals(1, result);
		
	}
	
//	@Test
//	public void given_New_Elevator_CurrentStatus_Should_Be_Default()
//	{
//		int floorTarget = 1;
//		Elevator elevator = new Elevator();
//		
//		ElevatorStatus eStatus = elevator.getElevatorStatus();
////		ElevatorDirection eDir = elevator.getDirection(); _and_Direction_Up
//		
//		assertEqual();
//	}
	
	// Remove the entry after reaching the destination floor
	
	@Test
	public void given_Elevator_going_it_does_accelerate() {
	}
	
	@Test
	public void given_Elevator_going_it_does_deccelearte() {
	}
	
	@Test
	public void given_Elevator_going_it_does_changeFloors() {
	}
	
	@Test
	public void given_Elevator_going_it_does_serviceFloor() {
	}
	
	@Test
	public void given_Elevator_going_it_does_checkOverCapacity() {
	}

}
