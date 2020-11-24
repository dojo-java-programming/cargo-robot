package com.github.verhagen.tutorial.cargorobot;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CraneTest {
	
	@Test
	public void commandMoveRight() throws Exception {
		int railLength = 4;
		Warehouse warehouse = new Warehouse(railLength, 3, "ABBA");
		assertEquals(warehouse.getCraneStatus(), "location '0'  no box");
		warehouse.execute("R");
		assertEquals(warehouse.getCraneStatus(), "location '1'  no box");
		warehouse.execute("R");
		assertEquals(warehouse.getCraneStatus(), "location '2'  no box");
		warehouse.execute("R");
		assertEquals(warehouse.getCraneStatus(), "location '3'  no box");
	}

	@Test
	public void commandMoveLeft() throws Exception {
		int railLength = 4;
		Warehouse warehouse = new Warehouse(railLength, 3, "   ");
		assertEquals(warehouse.getCraneStatus(), "location '0'  no box");
		warehouse.execute("R");
		assertEquals(warehouse.getCraneStatus(), "location '1'  no box");
		warehouse.execute("L");
		assertEquals(warehouse.getCraneStatus(), "location '0'  no box");
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
		Warehouse warehouse = new Warehouse(railLength, 2, "A");
		assertEquals(warehouse.getCraneStatus(), "location '0'  no box");
		warehouse.execute("D");
		assertEquals(warehouse.getCraneStatus(), "location '0'  box: 'A'  box-number: '0'");
		warehouse.execute("D");
		assertEquals(warehouse.getCraneStatus(), "location '0'  no box");
	}

}
