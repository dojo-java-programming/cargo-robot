package com.github.verhagen.tutorial.cargorobot.core;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.verhagen.tutorial.cargorobot.CargoRobotFeatures;

public class CraneTest {
	
	@Test
	public void commandMoveRight() {
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
	public void commandMoveLeft() {
		int railLength = 4;
		Warehouse warehouse = new Warehouse(railLength, 3, "   ");
		assertEquals(warehouse.getCraneStatus(), "location '0'  no box");
		warehouse.execute("R");
		assertEquals(warehouse.getCraneStatus(), "location '1'  no box");
		warehouse.execute("L");
		assertEquals(warehouse.getCraneStatus(), "location '0'  no box");
	}

	@Test
	public void commandTooFarLeft() {
		int railLength = 4;
		Warehouse warehouse = new Warehouse(railLength, 3, "   ");
		assertEquals(warehouse.getCraneStatus(), "location '0'  no box");
		
		if (CargoRobotFeatures.FEATURE_CRANE_SAFE_MOVEMENT.isActive()) {
			warehouse.execute("L");
			assertEquals(warehouse.getCraneStatus(), "location '0'  no box");
		}
		else {
			try {
				warehouse.execute("L");
			}
			catch (CraneException ce) {
				assertEquals(ce.getMessage(), "Crane is derailed on the left of it's rail.");		
			}
		}
	}
	
	@Test
	public void commandTooRightLeft() {
		int railLength = 4;
		Warehouse warehouse = new Warehouse(railLength, 3, "   ");
		assertEquals(warehouse.getCraneStatus(), "location '0'  no box");
		warehouse.execute("RRR");
		assertEquals(warehouse.getCraneStatus(), "location '3'  no box");

		if (CargoRobotFeatures.FEATURE_CRANE_SAFE_MOVEMENT.isActive()) {
			warehouse.execute("R");
			assertEquals(warehouse.getCraneStatus(), "location '3'  no box");
		}
		else {
			try {
				warehouse.execute("R");
			}
			catch (CraneException ce) {
				assertEquals(ce.getMessage(), "Crane is derailed on the right of it's rail.");		
			}
		}
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
	public void commandDown() {
		int railLength = 1;
		Warehouse warehouse = new Warehouse(railLength, 2, "A");
		assertEquals(warehouse.getCraneStatus(), "location '0'  no box");
		warehouse.execute("D");
		assertEquals(warehouse.getCraneStatus(), "location '0'  box: 'A'  box-number: '0'");
		warehouse.execute("D");
		assertEquals(warehouse.getCraneStatus(), "location '0'  no box");
	}

}
