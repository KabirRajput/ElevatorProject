package com.fdmgroup.elevatorproject.model;

import java.util.List;

public class ElevatorLogic {
	private List<Elevator> elevatorList;

	public ElevatorLogic(List<Elevator> elevatorList) {
		this.elevatorList = elevatorList;
	}

	public Elevator assignFloor(int i, int j) {
		elevatorList.get(0).addFloor(i);
		elevatorList.get(0).addFloor(j);
		
		return elevatorList.get(0);
	}

}
