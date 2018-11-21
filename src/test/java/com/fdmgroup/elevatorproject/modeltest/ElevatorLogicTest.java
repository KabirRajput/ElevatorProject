package com.fdmgroup.elevatorproject.modeltest;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import com.fdmgroup.elevatorproject.model.Elevator;
import com.fdmgroup.elevatorproject.model.ElevatorLogic;

public class ElevatorLogicTest {
	@Test
	public void given_only_1_elevator_assign_floors_to_that_elevator() {
		// Arrange
		Elevator elevator = new Elevator();
		List<Elevator> elevatorList = new ArrayList<Elevator>();
		elevatorList.add(elevator);
		ElevatorLogic logic = new ElevatorLogic(elevatorList);
		
		// Act
		Elevator elevatorAssigned = logic.assignFloor(0, 1);
		
		// Assert
		assertEquals(elevator, elevatorAssigned);
	}
	
	@Test
	public void given_Elevator_0_1_it_adds_to_elevator_floor_list() {
		// Arrange
		Elevator elevator = new Elevator();
		List<Elevator> elevatorList = new ArrayList<Elevator>();
		elevatorList.add(elevator);
		ElevatorLogic logic = new ElevatorLogic(elevatorList);
		
		// Act
		Elevator elevatorAssigned = logic.assignFloor(0, 1);
		
		// Assert	
		assertEquals(0, (int) elevatorAssigned.getFloorList().get(0));
		assertEquals(1, (int) elevatorAssigned.getFloorList().get(1));
	}

	
	@Test
	public void test_prevent_dubplicate_given_Elevator_floorList_1_3_assign_floor_1_3_returns1_3() {
		// Arrange
		Elevator elevator = new Elevator();
		List<Elevator> elevatorList = new ArrayList<Elevator>();
		elevator.addFloor(1);
		elevator.addFloor(3);
		elevatorList.add(elevator);
		
		ElevatorLogic logic = new ElevatorLogic(elevatorList);
		
		// Act
		Elevator elevatorAssigned = logic.assignFloor(1, 3);
		
		// Assert
		assertEquals(1, (int) elevatorAssigned.getFloorList().get(0));
		assertEquals(3, (int) elevatorAssigned.getFloorList().get(1));
	}
	
	
}
