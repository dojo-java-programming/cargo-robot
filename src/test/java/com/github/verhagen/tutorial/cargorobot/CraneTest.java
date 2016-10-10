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
		// FIXME 1
		// TODO Add assert for new position
		fail("Implement the TODO items");
	}

	@Test
	public void commandMoveRightOnMaxRight() throws Exception {
		int railLength = 4;
		Crane crane = new Crane(railLength, railLength -1);
		// FIXME 3
		// TODO Add assert for position
		// TODO Move the crane right
		// TODO Add assert for position is the same
		fail("Implement the TODO items");
	}

	@Test
	public void commandMoveLeft() throws Exception {
		int railLength = 4;
		Crane crane = new Crane(railLength, railLength -1);
		// FIXME 2
		// TODO Add assert for position
		// TODO Move Left
		// TODO Add assert for new position
		fail("Implement the TODO items");
	}

	@Test
	public void commandMoveLeftOnMaxLeft() throws Exception {
		int railLength = 4;
		Crane crane = new Crane(railLength, 0);
		// FIXME 4
		// TODO Add assert for position
		// TODO Move the crane left
		// TODO Add assert for position is the same
		fail("Implement the TODO items");
	}

}
