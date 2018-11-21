package com.fdmgroup.elevatorproject.model;

import java.util.*;

public class Elevator {

	private int currentFloor;
	private int minFloor = 0;
	private ElevatorStatus currentStatus = ElevatorStatus.DEFAULT;
	private ElevatorDirection dir = ElevatorDirection.UP;
	private List<Integer> floorList = new LinkedList<Integer>();
	
	public void go(int i) {
		setCurrentFloor(i);
	}

	public void moveUp(){
		dir = ElevatorDirection.UP;
	}

	public void moveDown(){
		dir = ElevatorDirection.DOWN;
	}

	public boolean isMoving(){
		return dir.equals(ElevatorDirection.STATIONARY);
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int floor) {
		this.currentFloor = floor;
	}

	public List<Integer> getFloorList() {
		return floorList;
	}
	
	public void addFloor(int floor) {
		floorList.add(floor);
	}
	
	public void addFloor(int floorIndex, int floor) {
		floorList.add(floorIndex, floor);
	}

}
