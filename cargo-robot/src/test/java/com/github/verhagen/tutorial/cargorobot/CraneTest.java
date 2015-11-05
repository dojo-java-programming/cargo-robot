package com.github.verhagen.tutorial.cargorobot;

import org.testng.annotations.Test;

public class CraneTest {
	
	@Test
	public void commandMoveRight() throws Exception {
//		Warehouse warehouse = null;
		int railLength = 4;
//		Crane crane = new Crane(warehouse, railLength);
//		crane.moveRight();
		Warehouse warehouse = new Warehouse(3, railLength, "   ");
		warehouse.execute("R");
	}

	@Test
	public void commandMoveLeft() throws Exception {
		int railLength = 4;
//		Crane crane = new Crane(warehouse, railLength, railLength -1);
		Warehouse warehouse = new Warehouse(3, railLength, "   ");
		warehouse.execute("L");
	}

	@Test( expectedExceptions = { IllegalArgumentException.class } )
	public void placeToFarLeft() throws Exception {
		Warehouse warehouse = null;
		int railLength = 4;
		new Crane(warehouse, railLength, -1);
	}

	@Test( expectedExceptions = { IllegalArgumentException.class } )
	public void placeToFarRight() throws Exception {
		Warehouse warehouse = null;
		int railLength = 4;
		new Crane(warehouse, railLength, railLength);
	}
	
	
	@Test
	public void commandDown() throws Exception {
		int railLength = 1;
		Warehouse warehouse = new Warehouse(1, railLength, "A");
//		Crane crane = new Crane(warehouse, railLength);
//		crane.moveDown();
		warehouse.execute("D");
	}

}
