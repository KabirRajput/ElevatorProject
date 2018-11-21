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
		
		if (!selectedElevator.getFloorList().contains(i)) {
			selectedElevator.addFloor(i);
		}
		
		if (!selectedElevator.getFloorList().contains(j)) {
			selectedElevator.addFloor(j);
		}
		
		
		System.out.println(selectedElevator.getFloorList());
		return selectedElevator;
	}

}
