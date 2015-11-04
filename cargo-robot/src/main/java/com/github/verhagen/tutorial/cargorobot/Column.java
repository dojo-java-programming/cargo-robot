package com.github.verhagen.tutorial.cargorobot;

import java.util.LinkedList;

public class Column {
	private final int capacity;
	private LinkedList<Box> boxes;


	public Column(int capacity) {
		this.capacity = capacity;
		boxes = new LinkedList<Box>();
	}


	public void put(Box box) {
		if (box == null) { 
			return;
		}
		if (boxes.size() >= capacity) {
			throw new ColumnCapacityException("Column capacity '" + capacity + "' is already reached.");
		}

		boxes.push(box);
	}


	public Box get() {
		if (boxes.isEmpty()) {
			return null;
		}
		return boxes.pop();
	}

}
