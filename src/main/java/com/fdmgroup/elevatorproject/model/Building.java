package com.fdmgroup.elevatorproject.model;

import java.util.*;

public class Building {
	private int maxFloor;
	private List<Elevator> elevatorList;

	public Building(List<Elevator> elevatorList, int noOfFloors) {
		this.elevatorList = elevatorList;
		this.maxFloor = noOfFloors-1;
	}

	public int getMaxFloor() {
		return maxFloor;
	}

	public List<Elevator> getAllElevators() {
		return elevatorList;
	}

}
