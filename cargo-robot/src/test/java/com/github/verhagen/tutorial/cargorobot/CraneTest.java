package com.github.verhagen.tutorial.cargorobot;

import org.testng.annotations.Test;

public class CraneTest {
	
	@Test
	public void commandMoveRight() throws Exception {
		int railLength = 4;
		Crane crane = new Crane(railLength);
		crane.moveRight();
	}

	@Test
	public void commandMoveLeft() throws Exception {
		int railLength = 4;
		Crane crane = new Crane(railLength, railLength -1);
		crane.moveLeft();
	}

	@Test( expectedExceptions = { IllegalArgumentException.class } )
	public void placeToFarLeft() throws Exception {
		int railLength = 4;
		new Crane(railLength, -1);
	}

	@Test( expectedExceptions = { IllegalArgumentException.class } )
	public void placeToFarRight() throws Exception {
		int railLength = 4;
		new Crane(railLength, railLength);
	}
	
	
	@Test
	public void commandDown() throws Exception {
		int railLength = 1;
		Crane crane = new Crane(railLength);
		crane.moveDown();
	}

}
