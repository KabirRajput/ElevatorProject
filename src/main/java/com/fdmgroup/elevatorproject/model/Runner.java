package com.fdmgroup.elevatorproject.model;

public class Runner extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Elevator e1 = new Elevator();
		Thread t1 = new Thread(e1);
		t1.setName("Elevator 1: ");
		
		e1.addFloor(1);
		e1.addFloor(2);
		e1.addFloor(5);
		e1.addFloor(8);
		
		t1.start();
	}

}
