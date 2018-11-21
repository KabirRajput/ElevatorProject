package com.fdmgroup.elevatorproject.modeltest;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import com.fdmgroup.elevatorproject.model.Elevator;
import com.fdmgroup.elevatorproject.model.ElevatorLogic;

public class ElevatorLogicTest {
	@Test
	public void given_Elevator_0_1_it_adds_to_elevator_floor_list() {
		
		Elevator elevator = new Elevator();
		List<Elevator> elevatorList = new ArrayList<Elevator>();
		elevatorList.add(elevator);
		
		ElevatorLogic logic = new ElevatorLogic(elevatorList);
		
		
		Elevator elevatorAssigned = logic.assignFloor(0, 1);
				
//		assertEquals(0, (int) elevatorAssigned.getFloorList().poll());
//		assertEquals(1, (int) elevatorAssigned.getFloorList().poll());
	}
}
