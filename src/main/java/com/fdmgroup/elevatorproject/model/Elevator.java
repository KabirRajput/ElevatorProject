package com.fdmgroup.elevatorproject.model;

import java.util.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Elevator extends Thread implements Movable{
	
	static Logger log = LogManager.getLogger(Elevator.class);

	private int currentFloor = 0;
	private ElevatorStatus currentStatus = ElevatorStatus.DEFAULT;
	private ElevatorDirection dir = ElevatorDirection.UP;
	private LinkedList<Integer> floorList = new LinkedList<Integer>();

	public void go(int targetFloor) {

		log.info("Floors to go: " + floorList);
		log.info("Current Floor: " + currentFloor + ", Target Floor: " + targetFloor);
		
		floorList.pop();

		if(targetFloor - currentFloor > 0)
		{
			changeToUp();
		}else{
			changeToDown();
		}

		accelerate(1000);
		changeFloor(1000, targetFloor);
		decelerate(1000);
		serviceFloor(2000);
		setCurrentFloor(targetFloor);
	}

	@Override
	public void run() {
		while (true) 
		{
			synchronized(floorList) {
				if (!floorList.isEmpty()) {
					go(floorList.getFirst());
				} else if (floorList.isEmpty() && currentStatus == ElevatorStatus.SERVICING) {
					restoreToDefault();
				}
				
			}
		}
	}

	public void changeToUp(){
		dir = ElevatorDirection.UP;

		log.info("Direction: " + dir);
	}

	public void changeToDown(){
		dir = ElevatorDirection.DOWN;

		log.info("Direction: " + dir);
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
		currentStatus = ElevatorStatus.ACCELERATING;

		try {
			Thread.sleep(cost);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info("Current Status: " + currentStatus);
	}

	public void decelerate(int cost) {
		currentStatus = ElevatorStatus.DECELERATING;

		try {
			Thread.sleep(cost);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.info("Current Status: " + currentStatus);
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

			log.info("Current Floor: " + currentFloor);
			log.info("Current Status: " + currentStatus);

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

		log.info("Current Status: " + currentStatus);
	}

	public void restoreToDefault() {
		floorList.add(0);
		go(0);
		this.dir = ElevatorDirection.UP;
		this.currentStatus = ElevatorStatus.DEFAULT;
	}
}
