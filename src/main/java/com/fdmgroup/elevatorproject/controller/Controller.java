package com.fdmgroup.elevatorproject.controller;

import com.fdmgroup.elevatorproject.model.Elevator;
import com.java.ood.elevatorproject.view.SystemView;

public class Controller {

	private Elevator elevator;
	private SystemView view;

	public Controller(Elevator elevator, SystemView view) {
		super();
		this.elevator = elevator;
		this.view = view;
	}

	public void updateView() {
		// TODO Auto-generated method stub

	}

}
