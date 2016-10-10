package com.github.verhagen.tutorial.cargorobot;

import static org.junit.Assert.*;

import org.junit.Test;

public class CraneTest {
	
	@Test
	public void commandMoveRight() throws Exception {
		int railLength = 4;
		Crane crane = new Crane(railLength);
		assertEquals(0, crane.getLocation());

		crane.moveRight();
		assertEquals(1, crane.getLocation());
	}

	@Test
	public void commandMoveRightOnMaxRight() throws Exception {
		int railLength = 4;
		Crane crane = new Crane(railLength, railLength -1);
		assertEquals(3, crane.getLocation());

		crane.moveRight();
		assertEquals(3, crane.getLocation());
	}

	@Test
	public void commandMoveLeft() throws Exception {
		int railLength = 4;
		Crane crane = new Crane(railLength, railLength -1);
		assertEquals(3, crane.getLocation());

		crane.moveLeft();
		assertEquals(2, crane.getLocation());
	}

	@Test
	public void commandMoveLeftOnMaxLeft() throws Exception {
		int railLength = 4;
		Crane crane = new Crane(railLength, 0);
		assertEquals(0, crane.getLocation());

		crane.moveLeft();
		assertEquals(0, crane.getLocation());
	}

}
