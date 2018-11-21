package com.fdmgroup.elevatorproject.model;

import java.util.*;

public class ElevatorLogic {
	private List<Elevator> elevatorList;

	public ElevatorLogic(List<Elevator> elevatorList) {
		this.elevatorList = elevatorList;
	}

	public Elevator assignFloor(int i, int j) {
		Elevator selectedElevator = null;
		if (elevatorList.size() == 1) {
			selectedElevator = elevatorList.get(0);
		}
		
			selectedElevator.addFloor(i);
			selectedElevator.addFloor(j);
		
		return selectedElevator;
	}

}
