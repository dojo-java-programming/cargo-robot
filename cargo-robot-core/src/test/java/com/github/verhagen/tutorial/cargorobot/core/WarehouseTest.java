package com.github.verhagen.tutorial.cargorobot.core;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.verhagen.tutorial.cargorobot.CargoRobotFeatures;

public class WarehouseTest {

	@Test
	public void createWarehouse() throws Exception {
		int width = 4;
		int heigth = 3;
		StringBuilder bldr = new StringBuilder();
		bldr.append("....\n");
		bldr.append("....\n");
		bldr.append("A...\n");
		Warehouse warehouse = new Warehouse(width, heigth, bldr.toString());
		Assert.assertEquals(warehouse.getCraneStatus(), "location '0'  no box");
		
		String content = warehouse.toString();
		Assert.assertEquals(content, bldr.toString());
	}

	@Test
	public void createWarehouseIncorrectFilling() throws Exception {
		int width = 4;
		int heigth = 3;
		StringBuilder bldr = new StringBuilder();
		bldr.append("....\n");
		bldr.append("..\n");
		bldr.append("A...\n");
		new Warehouse(width, heigth, bldr.toString());
	}


	@Test
	public void executeUnknownCommand() throws Exception {
		int width = 2;
		int heigth = 2;
		StringBuilder bldr = new StringBuilder();
		bldr.append("..\n");
		bldr.append("A.\n");

		Warehouse warehouse = new Warehouse(width, heigth, bldr.toString());
		assertEquals(warehouse.getWidth(), 2);
		warehouse.execute("Q");
		// TODO Check that logging contains warning ...
	}

	@Test
	public void moveBox() throws Exception {
		int width = 2;
		int heigth = 2;
		StringBuilder bldr = new StringBuilder();
		bldr.append("..\n");
		bldr.append("A.\n");
		StringBuilder expected = new StringBuilder();
		expected.append("..\n");
		expected.append(".A\n");

		Warehouse warehouse = new Warehouse(width, heigth, bldr.toString());
		
		String content = warehouse.toString();
		Assert.assertEquals(content, bldr.toString());
		
		Assert.assertEquals(warehouse.getCraneStatus(), "location '0'  no box");
		warehouse.execute("D");
		// FIXME [20161019 TV] Correct BoxFactory, should create serialNo 0 for each new Warehouse. 
		Assert.assertEquals(warehouse.getCraneStatus(), "location '0'  box: 'A'  box-number: '0'");  // FIXME 5 should be 1
		warehouse.execute("R");
		Assert.assertEquals(warehouse.getCraneStatus(), "location '1'  box: 'A'  box-number: '0'");  // FIXME 5 should be 1
		warehouse.execute("D");
		Assert.assertEquals(warehouse.getCraneStatus(), "location '1'  no box");
		content = warehouse.toString();
		Assert.assertEquals(content, expected.toString());
		
		warehouse.execute("D");
		warehouse.execute("L");
		warehouse.execute("D");
		content = warehouse.toString();
		Assert.assertEquals(content, bldr.toString());
	}


	@Test
	public void placeBoxInFullColumn() throws Exception {
		int width = 2;
		int heigth = 2;
		StringBuilder bldr = new StringBuilder();
		bldr.append(".B\n");
		bldr.append("AB\n");

		Warehouse warehouse = new Warehouse(width, heigth, bldr.toString());
		assertEquals(warehouse.getWidth(), 2);
		Assert.assertEquals(warehouse.getCraneStatus(), "location '0'  no box");
		warehouse.execute("DR");
		Assert.assertEquals(warehouse.getCraneStatus(), "location '1'  box: 'A'  box-number: '0'");

		if (CargoRobotFeatures.FEATURE_CRANE_SAFE_STACKING_OF_BOXES.isActive()) {
			warehouse.execute("D");
			Assert.assertEquals(warehouse.getCraneStatus(), "location '1'  box: 'A'  box-number: '0'");
			warehouse.execute("LD");
			Assert.assertEquals(warehouse.getCraneStatus(), "location '0'  no box");
		}
		else {
			warehouse.execute("D");
			Assert.assertEquals(warehouse.getCraneStatus(), "location '1'  no box");

			try {
				warehouse.execute("L");
			}
			catch (CraneException ce) {
				assertEquals(ce.getMessage(), "Crane failure, too many boxes in current column.");
			}

			try {
				warehouse.execute("R");
			}
			catch (CraneException ce) {
				assertEquals(ce.getMessage(), "Crane failure, too many boxes in current column.");
			}

			warehouse.execute("D");
			Assert.assertEquals(warehouse.getCraneStatus(), "location '1'  box: 'A'  box-number: '0'");
		}
	}

}
