package com.java.ood.elevatorproject.model;

import java.util.*;

public class Elevator {

	private int currentFloor;
	Direction dir;
	Queue<Integer> floorList = new LinkedList<Integer>();
	
	public void go(int i) {
		setCurrentFloor(i);
	}

	public void moveUp(){
		dir = Direction.UP;
	}

	public void moveDown(){
		dir = Direction.DOWN;
	}

	public boolean isMoving(){
		return dir.equals(Direction.STATIONARY);
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int floor) {
		this.currentFloor = floor;
	}

	public Queue<Integer> getFloorList() {
		return floorList;
	}
	
	public void addFloor(int i) {
		floorList.add(i);
	}

}
