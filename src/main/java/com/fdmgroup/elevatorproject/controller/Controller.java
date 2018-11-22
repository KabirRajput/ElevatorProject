package com.fdmgroup.elevatorproject.controller;

import java.util.Observable;
import com.fdmgroup.elevatorproject.model.*;
import com.fdmgroup.elevatorproject.view.*;

public class Controller {

	private SystemView view;
	private ElevatorScheduler eScheduler;
	private Building building;

	public Controller(SystemView view,ElevatorScheduler eScheduler,Building building) {
		super();
		this.view = view;
		this.eScheduler = eScheduler;
		this.building = building;
	}

	public void acceptCommand(Command c) {
		if(eScheduler!=null) { 
			eScheduler.assignFloor(c.currentFloor, c.destinationFloor);
		}
	}

	public void initConfiguration(int noOfBuilding,int noOfElevator) {

		if(noOfElevator>0) {
			for(int i=0;i<noOfElevator;i++) {
				Elevator elevator = new Elevator();
				this.building.addElevator(elevator);
				elevator.setName("Elevator "+ (i+1));
				elevator.start();
			}	
		}else {
			view.printError();
		}

	}

	public void update(Observable o, Object printOutMessage) {
		view.printOutput(printOutMessage.toString());
	}
}
