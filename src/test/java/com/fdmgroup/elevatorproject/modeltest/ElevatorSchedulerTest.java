package com.fdmgroup.elevatorproject.modeltest;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import com.fdmgroup.elevatorproject.model.Building;
import com.fdmgroup.elevatorproject.model.Elevator;
import com.fdmgroup.elevatorproject.model.ElevatorScheduler;

public class ElevatorSchedulerTest {
	@Test
	public void given_only_1_elevator_assign_floors_to_that_elevator() {
		// Arrange
		Elevator elevator = new Elevator();
		Building building = new Building(40);
		building.addElevator(elevator);
		ElevatorScheduler scheduler = new ElevatorScheduler(building);
		
		// Act
		Elevator elevatorAssigned = scheduler.assignFloor(0, 1);
		
		// Assert
		assertEquals(elevator, elevatorAssigned);
	}
	
	@Test
	public void given_Elevator_0_1_it_adds_to_elevator_floor_list() {
		// Arrange
		Elevator elevator = new Elevator();
		Building building = new Building(40);

		ElevatorScheduler scheduler = new ElevatorScheduler(building);
		building.addElevator(elevator);
		
		// Act
		Elevator elevatorAssigned = scheduler.assignFloor(0, 1);
		
		// Assert	
		assertEquals(0, elevatorAssigned.getFloorList().get(0).intValue());
		assertEquals(1, elevatorAssigned.getFloorList().get(1).intValue());
	}
	
	@Test
	public void given_2_Elevators_choose_assign_floors_to_floorSize_with_min_length() {
		// Arrange
		Elevator elevator1 = new Elevator();
		Elevator elevator2 = new Elevator();
		Building building = new Building(40);
		
		building.addElevator(elevator1);
		building.addElevator(elevator2);
		elevator1.addFloor(0);
		elevator1.addFloor(5);
		elevator2.addFloor(1);
		ElevatorScheduler scheduler = new ElevatorScheduler(building);
		
		// Act
		Elevator elevatorAssigned = scheduler.assignFloor(0, 1);
		
		// Assert	
		assertEquals(elevator2, elevatorAssigned);
	}
	
	
}
