package OOD3_Elevator_Kabir.elevatorProject;

import java.util.LinkedList;
import java.util.List;

public class Elevator {

	private int floor;
	Direction dir;
	List<Integer> floorList = new LinkedList<Integer>();
	
	public void go(int i) {
		floorList.add(i);
	}

	public void moveUp(){
		dir = Direction.UP;
	}

	public void moveDown(){
		dir = Direction.DOWN;
	}

	public boolean isMoving(){
		return dir.equals(Direction.STATIONARY);
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public List<Integer> getList() {
		return floorList;
	}

}
