package com.github.verhagen.tutorial.cargorobot;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CraneTest {
	
	@Test
	public void commandMoveRight() throws Exception {
		int railLength = 4;
		Crane crane = new Crane(railLength);
		assertEquals(crane.getLocation(), 0);

		crane.moveRight();
		assertEquals(crane.getLocation(), 1);
	}

	@Test
	public void commandMoveLeft() throws Exception {
		int railLength = 4;
		Crane crane = new Crane(railLength, railLength -1);
		assertEquals(crane.getLocation(), 3);

		crane.moveLeft();
		assertEquals(crane.getLocation(), 2);
	}

}
