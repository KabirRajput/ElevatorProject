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
		Building building = new Building(new ArrayList<Elevator>(),40);
		ElevatorScheduler scheduler = new ElevatorScheduler(building);
		building.addElevator(elevator);
		
		// Act
		Elevator elevatorAssigned = scheduler.assignFloor(0, 1);
		
		// Assert
		assertEquals(elevator, elevatorAssigned);
	}
	
	@Test
	public void given_Elevator_0_1_it_adds_to_elevator_floor_list() {
		// Arrange
		Elevator elevator = new Elevator();
		Building building = new Building(new ArrayList<Elevator>(),40);

		ElevatorScheduler scheduler = new ElevatorScheduler(building);
		building.addElevator(elevator);
		
		// Act
		Elevator elevatorAssigned = scheduler.assignFloor(0, 1);
		
		// Assert	
		assertEquals(0, (int) elevatorAssigned.getFloorList().get(0));
		assertEquals(1, (int) elevatorAssigned.getFloorList().get(1));
	}
}
