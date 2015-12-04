package com.github.verhagen.tutorial.cargorobot;

import java.util.LinkedList;

public class Column {
	private final int capacity;
	private LinkedList<Box> boxes;


	public Column(int capacity) {
		this.capacity = capacity;
		boxes = new LinkedList<Box>();
	}
	

	/** Clears the column, remove all boxes.*/
	public void clear() {
		boxes.clear();
	}


	public void put(Box box) {
		if (box == null) { 
			return;
		}
		if (! isCapacityAvailable()) {
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


	public Box peek(int heigth) {
		System.out.println("No of boxes " + boxes.size() + " h: " + heigth);
		if (boxes.isEmpty()) {
			return null;
		}
		if (heigth >= boxes.size()) {
			return null;
		}
		Box box = boxes.get(convertHeigthAsIndex(heigth));
		System.out.println("Peek[" + heigth + "] box " + box.getType());
		return box;
	}


	private int convertHeigthAsIndex(int heigth) {
		return boxes.size() -1 - heigth;
	}


	public int getCapacity() {
		return capacity;
	}


	public int availableCapacity() {
		return capacity - boxes.size();
	}


	public boolean isCapacityAvailable() {
		return (capacity - boxes.size()) > 0;
	}

}
