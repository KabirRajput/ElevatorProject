package com.fdmgroup.elevatorproject.model;

import java.util.*;

public class ElevatorScheduler {

	private Building building;

	public ElevatorScheduler(Building building) {
		this.building = building;
	}

	public Elevator assignFloor(int i, int j) {
		Elevator selectedElevator = null;
		if (building.getAllElevators().size() == 1) {
			selectedElevator = building.getAllElevators().get(0);
		}
			selectedElevator.addFloor(i);
			selectedElevator.addFloor(j);
		
		return selectedElevator;
	}
	

}
