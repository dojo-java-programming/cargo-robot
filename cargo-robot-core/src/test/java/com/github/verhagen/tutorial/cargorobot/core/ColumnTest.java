package com.github.verhagen.tutorial.cargorobot.core;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import org.testng.annotations.Test;

import com.github.verhagen.tutorial.cargorobot.CargoRobotFeatures;

public class ColumnTest {

	@Test
	public void empty() throws Exception {
		Column column = new Column(2);
		column.put(null);
		column.put(null);
		column.put(null);

		assertNull(column.get());
		assertNull(column.get());
	}

	@Test
	public void addOneBox() throws Exception {
		Box box = new Box(BoxType.A, 0);
		Column column = new Column(2);
		column.put(box);

		assertEquals(box, column.get());
		assertNull(column.get());
	}

	@Test
	public void addTwoBoxes() throws Exception {
		Box box0 = new Box(BoxType.A, 0);
		Box box1 = new Box(BoxType.A, 1);
		Column column = new Column(2);
		assertEquals(column.getCapacity(), 2);
		assertEquals(column.getAvailableCapacity(), 2);
		column.put(box0);
		column.put(box1);
		assertEquals(column.getCapacity(), 2);
		assertEquals(column.getAvailableCapacity(), 0);
		column.put(null);
		assertEquals(column.getCapacity(), 2);
		assertEquals(column.getAvailableCapacity(), 0);

		assertEquals(column.get(), box1);
		assertEquals(column.get(), box0);
		assertNull(column.get());
		assertEquals(column.getCapacity(), 2);
		assertEquals(column.getAvailableCapacity(), 2);
	}

	@Test
	public void addThreeBoxes() throws Exception {
		Box box0 = new Box(BoxType.A, 0);
		Box box1 = new Box(BoxType.A, 1);
		Box box2 = new Box(BoxType.A, 2);
		Column column = new Column(2);
		column.put(box0);
		column.put(box1);
		if (CargoRobotFeatures.FEATURE_CRANE_SAFE_STACKING_OF_BOXES.isActive()) {
			try {
				assertEquals(column.getAvailableCapacity(), 0);
				column.put(box2);
			}
			catch (ColumnCapacityException cce) {
				assertEquals(cce.getMessage(), "Column capacity '2' is already reached.");
				assertEquals(column.getAvailableCapacity(), 0);
			}
		}
		else {
			assertEquals(column.getAvailableCapacity(), 0);
			column.put(box2);
			assertEquals(column.getAvailableCapacity(), -1);
			column.put(new Box(BoxType.A, 3));
			assertEquals(column.getAvailableCapacity(), -2);
		}
	}

	@Test
	public void peekHeight() throws Exception {
		Box box0 = new Box(BoxType.A, 0);
		Box box1 = new Box(BoxType.A, 1);
		Box box2 = new Box(BoxType.A, 2);
		
		Column column = new Column(3);
		assertNull(column.peek(0), "No box expected at height '0'");

		column.put(box0);
		assertEquals(column.peek(0), box0);
		assertNull(column.peek(1), "No box expected at height '1'");
		
		column.put(box1);
		assertEquals(column.peek(0), box0);
		assertEquals(column.peek(1), box1);

		column.put(box2);
		assertEquals(column.peek(0), box0);
		assertEquals(column.peek(1), box1);
		assertEquals(column.peek(2), box2);
	}
}
