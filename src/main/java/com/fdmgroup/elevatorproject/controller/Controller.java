package com.fdmgroup.elevatorproject.controller;

import java.util.List;

import com.fdmgroup.elevatorproject.model.Elevator;
import com.fdmgroup.elevatorproject.model.ElevatorScheduler;
import com.fdmgroup.elevatorproject.view.Command;
import com.java.ood.elevatorproject.view.SystemView;

public class Controller {

	private List<Elevator> elevatorList;
	private SystemView view;
	private ElevatorScheduler eScheduler;

	public Controller(List<Elevator> elevator_list, SystemView view) {
		super();
		this.elevatorList = elevatorList;
		this.view = view;
	}

	public void updateView() {
		// TODO Auto-generated method stub

	}
	
	public void inputCommand(Command c) {
		eScheduler.assignFloor(c.currentFloor, c.destinationFloor);
	}
	
	public void initConfiguration(int noOfBuilding,int noOfElevator) {
		
		if(noOfElevator>0) {
			//Waiting teammate to implements Runnable/Thread to Elevator
			//Elevator.start() according to noOfElevator
		}
	}
	
	

}
