package com.fdmgroup.elevatorproject.runner;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.fdmgroup.elevatorproject.controller.Controller;
import com.fdmgroup.elevatorproject.model.Building;
import com.fdmgroup.elevatorproject.model.ElevatorScheduler;
import com.fdmgroup.elevatorproject.view.SystemView;

public class Runner {
	
	public static void main(String[] args) {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		Building building = new Building(40);
		SystemView sysView = new SystemView(br,System.in,System.out);
		ElevatorScheduler es = new ElevatorScheduler(building);
		
		Controller ec = new Controller(sysView, es, building);
		sysView.addController(ec);
		
		try {
			sysView.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
