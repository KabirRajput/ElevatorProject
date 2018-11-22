package com.fdmgroup.elevatorproject.view;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.PrintStream;

import com.fdmgroup.elevatorproject.controller.Controller;

public class SystemView {
	
	InputStream is;
	PrintStream ps;
	BufferedReader br;
	
	Controller ec;

	public SystemView(BufferedReader br,InputStream is,PrintStream ps) {
		this.ps = ps;
		this.is = is;
		this.br = br;
	}
	
	public void addController(Controller ec) {
		this.ec = ec;
	}

	public void init() throws Exception {
		
		ps.println("Welcome to Elevator System");
		ps.println("Define the intial Number of Building");
		String noOfBuildingInput = br.readLine();
		ps.println("Define the intial Number of Elevator");
		String noOfElevatorInput = br.readLine();
		ps.println("Instruction: A : A is the destination floor");
		
		int noOfBuildingInt = Integer.parseInt(noOfBuildingInput);
		int noOfElevatorInt = Integer.parseInt(noOfElevatorInput);
		run(noOfBuildingInt,noOfElevatorInt);
		
	}
	
	public void run(int noOfBuildingInt, int noOfElevatorInt) throws Exception {
		
		String c = "";
		ec.initConfiguration(noOfBuildingInt,noOfElevatorInt);
		//Waiting input all the time
		while(c.toUpperCase()!="Q") {
		c = inputCommand();
		}
		
	}
	
	public String inputCommand() throws Exception {
		if(ec!=null) {
			String i = br.readLine();
			int currentFloor = Integer.parseInt(i);
			String j = br.readLine();
			int destinationFloor = Integer.parseInt(j);
			if(validateCommand(i)) {
				Command c = new Command();
				c.currentFloor = currentFloor;
				c.destinationFloor = destinationFloor;
				ec.acceptCommand(c);
				return i;
			}
		}
		return null;
	}
	
	public boolean validateCommand(String command) {
		
		return true;
		
		//Define validate logic later on
	}
	
	public void printOutput(String message) {
		System.out.println(message);
	}
	
	public void printError() {
		System.out.println("Unexpected input");
	}
}
