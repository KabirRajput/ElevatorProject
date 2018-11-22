package com.fdmgroup.elevatorproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import com.fdmgroup.elevatorproject.model.Building;
import com.fdmgroup.elevatorproject.model.Elevator;
import com.fdmgroup.elevatorproject.model.ElevatorScheduler;
import com.fdmgroup.elevatorproject.view.Command;
import com.fdmgroup.elevatorproject.view.SystemView;


public class Controller implements java.util.Observer {

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
		if(eScheduler!=null) 
		eScheduler.assignFloor(c.currentFloor, c.destinationFloor);
	}
	
	public void initConfiguration(int noOfBuilding,int noOfElevator) {
		
		if(noOfElevator>0) {
			for(int i=0;i<noOfElevator;i++) {
				Elevator elevator = new Elevator();
				Thread t = new Thread(elevator);
				t.start();
				this.building.addElevator(elevator);
			}
			
		}else {
			view.printError();
		}
		
	}

	public void update(Observable o, Object printOutMessage) {
		// TODO Auto-generated method stub
		view.printOutput(printOutMessage.toString());
	}
	
	

}
