package com.fdmgroup.elevatorproject.model;

import java.util.*;

public class ElevatorScheduler {
	private List<Elevator> elevatorList;

	public ElevatorScheduler(List<Elevator> elevatorList) {
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
