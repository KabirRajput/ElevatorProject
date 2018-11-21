package com.fdmgroup.elevatorproject.model;

import java.util.*;

public class Elevator implements Movable{

	private int currentFloor = 0;
	private ElevatorStatus currentStatus = ElevatorStatus.DEFAULT;
	private ElevatorDirection dir = ElevatorDirection.UP;
	private LinkedList<Integer> floorList = new LinkedList<Integer>();

	public void go(int targetFloor) {

		if(currentFloor - targetFloor > 0)
		{
			changeToDown();
		}else {
			changeToUp();
		}

		setCurrentFloor(targetFloor);
	}

	public void elevatorListener() {
		while(floorList.size() > 0) // only for Unit Test, change to while(true) for production
		{
			if(floorList.size() > 0) {
				go(floorList.pop());
			}
			restoreToDefault();	
		}

	}

	public void changeToUp(){
		dir = ElevatorDirection.UP;
	}

	public void changeToDown(){
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

	public ElevatorStatus getElevatorStatus() {
		return currentStatus;
	}

	public ElevatorDirection getDirection() {
		return dir;
	}

	public void accelerate(int cost) {
		// TODO Auto-generated method stub
		currentStatus = ElevatorStatus.ACCELARATING;
	}

	public void decelerate(int cost) {
		// TODO Auto-generated method stub
		currentStatus = ElevatorStatus.DECELERATING;
	}

	public void changeFloor(int cost) {
		// TODO Auto-generated method stub
		currentStatus = ElevatorStatus.CHANGINGFLOORS;
	}

	public void serviceFloor(int cost) {
		// TODO Auto-generated method stub
		currentStatus = ElevatorStatus.SERVICING;
	}

	public void restoreToDefault() {
		// TODO Auto-generated method stub
		go(0);
		dir = ElevatorDirection.UP;
		currentStatus = ElevatorStatus.DEFAULT;

	}
}
