package com.fdmgroup.elevatorproject.modeltest;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import com.fdmgroup.elevatorproject.model.*;

public class ElevatorTest {
	@Test
	public void given_New_Elevator_CurrentStatus_Should_Be_Default()
	{
		Elevator elevator = new Elevator();
		
		ElevatorStatus eStatus = elevator.getElevatorStatus();
		
		assertEquals(ElevatorStatus.DEFAULT, eStatus);
	}
	
	@Test
	public void given_New_Elevator_CurrentDirection_Should_Be_UP()
	{
		Elevator elevator = new Elevator();
		
		ElevatorDirection eDir = elevator.getDirection();
		
		assertEquals(ElevatorDirection.UP, eDir);
	}
	
	@Test
	public void given_New_Elevator_CurrentFloor_Should_Be_0()
	{
		Elevator elevator = new Elevator();
		
		int floor = elevator.getCurrentFloor();
		
		assertEquals(0, floor);
	}
	
	@Test
	public void given_Elevator_From_0_To_1_when_getCurrentFloor_returns1() {
		
		int floorTarget = 1;
		Elevator elevator = new Elevator();
		
		elevator.addFloor(floorTarget);
		
		elevator.go(floorTarget);
		
		int result = elevator.getCurrentFloor();
		System.out.println(result);
		
		assertEquals(1, result);
		
	}
	
	@Test
	public void given_Elevator_From_3_To_1_when_getCurrentFloor_returns1_And_Change_Direction() {
		
		int floorTarget = 1;
		int currentFloor = 3;
		Elevator elevator = new Elevator();
		
		elevator.setCurrentFloor(currentFloor);
		elevator.addFloor(floorTarget);
		elevator.go(floorTarget);
		
		ElevatorDirection eDir = elevator.getDirection();
		
		assertEquals(ElevatorDirection.DOWN, eDir);
		
	}
	
	@Test
	public void given_Elevator_With_Three_TargetFloors_Remove_The_First_Element_Of_The_FloorList_When_It_Arrives()
	{
		int f1 = 1;
		int f2 = 2;
		int f3 = 5;
		int f4 = 8;
		
		Elevator elevator = new Elevator();
		
		elevator.addFloor(f1);
		elevator.addFloor(f2);
		elevator.addFloor(f3);
		elevator.addFloor(f4);
		
		elevator.go(f1);
		elevator.go(f2);
		elevator.go(f3);
		elevator.go(f4);
		
		elevator.run();
		
		List<Integer> floorList = elevator.getFloorList();
		
		assertTrue(floorList.isEmpty());
	}
	
	@Test
	public void given_Elevator_With_Empty_FloorList_It_Should_Restore_Default()
	{
		int f1 = 1;
		int f2 = 2;
		int f3 = 5;
		int f4 = 8;
		
		Elevator elevator = new Elevator();
		
		elevator.addFloor(f1);
		elevator.addFloor(f2);
		elevator.addFloor(f3);
		elevator.addFloor(f4);
		
		elevator.go(f1);
		elevator.go(f2);
		elevator.go(f3);
		elevator.go(f4);
		
		elevator.run();
		
		assertEquals(0, elevator.getCurrentFloor());
		assertEquals(ElevatorDirection.UP, elevator.getDirection());
		assertEquals(ElevatorStatus.DEFAULT, elevator.getElevatorStatus());
	}
	
	//TODO
	@Test
	public void given_Elevator_going_it_does_checkOverCapacity() {
	}

}
