package com.fdmgroup.elevatorproject.model;

import java.util.*;

public class Elevator extends Thread implements Movable{

	private int currentFloor = 0;
	private ElevatorStatus currentStatus = ElevatorStatus.DEFAULT;
	private ElevatorDirection dir = ElevatorDirection.UP;
	private LinkedList<Integer> floorList = new LinkedList<Integer>();

	public void go(int targetFloor) {
		System.out.println("Go: " + floorList);
		System.out.println("Current Floor: " + currentFloor + ", Target Floor: " + targetFloor);
		
		floorList.pop();

		if(targetFloor - currentFloor > 0)
		{
			changeToUp();
		}else{
			changeToDown();
		}

		accelerate(200);
		changeFloor(200, targetFloor);
		decelerate(200);
		serviceFloor(400);
		setCurrentFloor(targetFloor);
	}

	@Override
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

		System.out.println("Direction: " + dir);
	}

	public void changeToDown(){
		dir = ElevatorDirection.DOWN;

		System.out.println("Direction: " + dir);
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

		try {
			Thread.sleep(cost);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Current Status: " + currentStatus);
	}

	public void decelerate(int cost) {
		currentStatus = ElevatorStatus.DECELERATING;

		try {
			Thread.sleep(cost);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Current Status: " + currentStatus);
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

			System.out.println("Current Floor: " + currentFloor);
			System.out.println("Current Status: " + currentStatus);

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

		try {
			Thread.sleep(cost);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Current Status: " + currentStatus);
	}

	public void restoreToDefault() {
		floorList.add(0);
		go(0);
		this.dir = ElevatorDirection.UP;
		this.currentStatus = ElevatorStatus.DEFAULT;

	}
}
