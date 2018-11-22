package com.fdmgroup.elevatorproject.model;

import java.util.*;

public class Building {
	private int maxFloor;
	private List<Elevator> elevatorList;

	public Building(int noOfFloors) {
		this.elevatorList = new ArrayList<Elevator>();
		this.maxFloor = noOfFloors-1;
	}

	public int getMaxFloor() {
		return maxFloor;
	}

	public List<Elevator> getAllElevators() {
		return elevatorList;
	}
	
	public boolean addElevator(Elevator e) {
		return elevatorList.add(e);
	}

}
