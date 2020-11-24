package com.github.verhagen.tutorial.cargorobot.core;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Column {
	private final Logger logger = LoggerFactory.getLogger(Column.class);
	private final int capacity;
	private LinkedList<Box> boxes;


	public Column(final int capacity) {
		this.capacity = capacity;
		boxes = new LinkedList<Box>();
	}
	

	/** Clears the column, remove all boxes.*/
	public void clear() {
		boxes.clear();
	}


	public void put(final Box box) {
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


	public Box peek(final int heigth) {
		logger.debug("No of boxes " + boxes.size() + " h: " + heigth);
		if (boxes.isEmpty()) {
			return null;
		}
		if (heigth >= boxes.size()) {
			return null;
		}
		Box box = boxes.get(convertHeigthAsIndex(heigth));
		logger.debug("Peek[" + heigth + "] box " + box.getType());
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
