package com.fdmgroup.elevatorproject.model;

import java.util.*;

public class ElevatorScheduler {
	private Building building;

	public ElevatorScheduler(Building building) {
		this.building = building;
	}

	public Elevator assignFloor(int from, int to) {
		Elevator selectedElevator = null;
		List<Elevator> elevatorList = building.getAllElevators();
		if (elevatorList.size() == 1) {
			selectedElevator = elevatorList.get(0);
		} else {
			int minSize = Integer.MAX_VALUE;
			for (Elevator elev : elevatorList) {
				if (elev.getFloorList().size() < minSize) {
					minSize = elev.getFloorList().size();
					selectedElevator = elev;
				}
			}
			System.out.println(minSize + " | " +selectedElevator);
		}
		
		selectedElevator.addFloor(from);
		selectedElevator.addFloor(to);

		return selectedElevator;
	}
	

}