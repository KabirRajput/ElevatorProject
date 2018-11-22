package com.fdmgroup.elevatorproject.viewtest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.elevatorproject.controller.Controller;
import com.fdmgroup.elevatorproject.view.SystemView;

public class SystemViewTest {

	

	InputStream mockIs = mock(InputStream.class);
	
	PrintStream mockPs = mock(PrintStream.class);
	
	BufferedReader mockBufferReader = mock(BufferedReader.class);
	
	Controller mockEc = mock(Controller.class);
	
	@Test
	public void view_init() throws Exception {
		
		//Arrange
		SystemView sysView = new SystemView(mockBufferReader,mockIs,mockPs);
		when(mockBufferReader.readLine()).thenReturn("100").thenReturn("200");
		
		//Act
		sysView.addController(mockEc);
		sysView.init();
		
		//Assert
		verify(mockBufferReader,times(2)).readLine();
		
	}
	
	@Test
	public void view_command_input() throws Exception {
		
		//Arrange
		SystemView sysView = new SystemView(mockBufferReader,mockIs,mockPs);
		when(mockBufferReader.readLine()).thenReturn("1,3");
//		when(mockBufferReader.readLine()).thenReturn(true);
		
		//Act
		sysView.addController(mockEc);
		sysView.inputCommand();
		
		//Assert
		verify(mockBufferReader).readLine();
	}
	
	@Test
	public void validate_command_and_return_true() {
		SystemView sysView = new SystemView(mockBufferReader,mockIs,mockPs);
		Boolean isValid = sysView.validateCommand("1,3");
		assertEquals(true,isValid);
	}
}
