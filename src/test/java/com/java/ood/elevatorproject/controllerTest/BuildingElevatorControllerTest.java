package com.java.ood.elevatorproject.controllerTest;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import com.java.ood.elevatorproject.model.Building;
import com.java.ood.elevatorproject.model.Elevator;

public class BuildingElevatorControllerTest {


	@Test
	public void given_buildingWith10Floors_when_requestMaxFloor_then_return9() {
		Elevator elevator1 = new Elevator();
		List<Elevator> elevatorList = new ArrayList<Elevator>();
		elevatorList.add(elevator1);
		int noOfFloors = 10;

		Building building = new Building(elevatorList, noOfFloors);

		int result = building.getMaxFloor();

		assertEquals(9, result);

	}

	@Test
	public void test_Initializing_Building_with_G_To_9_With_1_elevator_returns_1_elevator() {
		Elevator elevator1 = new Elevator();
		Elevator elevator2 = new Elevator();
		List<Elevator> elevatorList = new ArrayList<Elevator>();
		elevatorList.add(elevator1);
		elevatorList.add(elevator2);

		System.out.println(elevatorList);
		int noOfFloors = 10;

		Building building = new Building(elevatorList, noOfFloors);

		List<Elevator> allElevators = building.getAllElevators();
		assertEquals(elevatorList, allElevators);

	}


}
