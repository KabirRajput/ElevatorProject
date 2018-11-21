package com.fdmgroup.elevatorproject.model;

public interface Movable {
	void accelerate(int cost);
	void decelerate(int cost);
	void changeFloor(int cost);
	void serviceFloor(int cost);
}
