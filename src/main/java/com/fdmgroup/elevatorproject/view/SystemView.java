package com.fdmgroup.elevatorproject.view;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
	
	public void run(int noOfBuildingInt, int noOfElevatorInt) {
		
		ec.initConfiguration(noOfBuildingInt,noOfElevatorInt);
		//Waiting input all the time
		
	}
	
	public void inputCommand() throws Exception {
		if(ec!=null) {
			String i = br.readLine();
			if(validateCommand(i)) {
				Command c = new Command();
				ec.inputCommand(c);
			}
		}
	}
	
	public boolean validateCommand(String command) {
		
		return true;
	}
	

}
