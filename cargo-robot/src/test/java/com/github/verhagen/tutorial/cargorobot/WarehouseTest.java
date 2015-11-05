package com.github.verhagen.tutorial.cargorobot;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WarehouseTest {

	@Test
	public void createWarehouse() throws Exception {
		int width = 4;
		int heigth = 3;
		StringBuilder bldr = new StringBuilder();
		bldr.append("    \n");
		bldr.append("    \n");
		bldr.append("A   \n");
		Warehouse warehouse = new Warehouse(width, heigth, bldr.toString());
		
		String content = warehouse.toString();
		Assert.assertEquals(content, bldr.toString());
	}
	
	
}
