package com.fdmgroup.elevatorproject.controllertest;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import com.fdmgroup.elevatorproject.controller.Controller;
import com.fdmgroup.elevatorproject.model.Building;
import com.fdmgroup.elevatorproject.model.Elevator;
import com.fdmgroup.elevatorproject.model.ElevatorScheduler;
import com.fdmgroup.elevatorproject.view.SystemView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class BuildingElevatorControllerTest {

	@Test 
	public void testingMVC_framework_add() {
		
		Observable o = mock(Observable.class);
		Object printOutMessage = mock(Object.class);
		SystemView view = mock(SystemView.class);
		ElevatorScheduler eScheduler = mock(ElevatorScheduler.class);
		Building building = mock(Building.class);
		Controller controller =  new Controller(view,eScheduler,building);
		
		
		controller.update(o, printOutMessage);

	}

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

	@Test
	public void controller_init_configuration() {
		SystemView view = mock(SystemView.class);
		Building building = new Building(new ArrayList<Elevator>(),40);
		ElevatorScheduler eScheduler = new ElevatorScheduler(building);
		Controller controller =  new Controller(view,eScheduler,building);
		controller.initConfiguration(1, 1);
		
		assertEquals(1,building.getAllElevators().size());
	}
	
}
