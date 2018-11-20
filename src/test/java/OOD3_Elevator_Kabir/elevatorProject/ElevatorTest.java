package OOD3_Elevator_Kabir.elevatorProject;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ElevatorTest {
	
	@Test
	public void test_Elevator_From_G_goes_To_1() {
		
		List<Integer> result = new ArrayList<Integer>();
		
		Elevator elevator = new Elevator();
		
		elevator.go(1);
		
		result = elevator.getList();
		
		assertEquals("[1]", result.toString());
		
	}
	
	@Test
	public void test_Elevator_From_G_goes_To_1_AND_2() {
		
		List<Integer> result = new ArrayList<Integer>();
		
		Elevator elevator = new Elevator();
		
		elevator.go(1);
		elevator.go(2);
		
		result = elevator.getList();
		
		assertEquals("[1, 2]", result.toString());
		
	}

}
