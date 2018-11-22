package com.fdmgroup.elevatorproject.model;

import java.util.*;

public class Elevator extends java.util.Observable implements Movable,Runnable{

	private int currentFloor = 0;
	private ElevatorStatus currentStatus = ElevatorStatus.DEFAULT;
	private ElevatorDirection dir = ElevatorDirection.UP;
	private LinkedList<Integer> floorList = new LinkedList<Integer>();

	public void go(int targetFloor) {

		floorList.pop();

		if(currentFloor - targetFloor > 0)
		{
			changeToDown();
		}else {
			changeToUp();
		}

		changeFloor(100, targetFloor);
		accelerate(100);
		decelerate(100);
		serviceFloor(200);
		setCurrentFloor(targetFloor);
		
		setChanged();
		notifyObservers("Go: " + floorList);
		
	//	System.out.println("Go: " + floorList);
	//  For println reference
	}

	public void run() {
		while(floorList.size() > 0) 
		{
			go(floorList.getFirst());
		}

		if(floorList.isEmpty()) {
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
		currentStatus = ElevatorStatus.ACCELARATING;
	}

	public void decelerate(int cost) {
		currentStatus = ElevatorStatus.DECELERATING;
	}

	public void changeFloor(int cost, int targetFloor) {
		currentStatus = ElevatorStatus.CHANGINGFLOORS;

		while(currentFloor != targetFloor) {
			if (dir == ElevatorDirection.UP)
			{
				setCurrentFloor(++currentFloor);
			} else if (dir == ElevatorDirection.DOWN) {
				setCurrentFloor(--currentFloor);
			}

			setChanged();
			notifyObservers("Current Floor: " + currentFloor);
			setChanged();
			notifyObservers("Current Status: " + currentStatus);
			
			try {
				Thread.sleep(cost);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void serviceFloor(int cost) {
		currentStatus = ElevatorStatus.SERVICING;
		
		setChanged();
		notifyObservers(currentStatus);
	}

	public void restoreToDefault() {
		floorList.add(0);
		go(0);
		this.dir = ElevatorDirection.UP;
		this.currentStatus = ElevatorStatus.DEFAULT;

	}

}
