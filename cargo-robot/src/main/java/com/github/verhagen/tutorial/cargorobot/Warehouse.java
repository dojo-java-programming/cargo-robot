package com.github.verhagen.tutorial.cargorobot;

import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Warehouse {
	private final Logger logger = LoggerFactory.getLogger(Warehouse.class);
	private final String originalFilling;
	private final Crane crane;
	private final Column[] columns;

	
	public Warehouse(int width, int heigth, String filling) {
		this.originalFilling = filling;

		crane = new Crane(width);
		columns = new Column[width];
		for (int columnNo = 0; columnNo < width; columnNo++) {
			columns[columnNo] = new Column(heigth);
		}

		reset();
	}
	
	
	/**
	 * Clears the warehouse, so it will not contain any Box.
	 */
	public void clear() {
		for (int columnNo = 0; columnNo < columns.length; columnNo++) {
			columns[columnNo].clear();
		}
	}


	/**
	 * Resets the warehouse content (filling).
	 */
	private void reset() {
		clear();

		StringTokenizer tokenizer = new StringTokenizer(originalFilling, "\n");
		LinkedList<String> rows = new LinkedList<>(); 
		while (tokenizer.hasMoreTokens()) {
			String row = tokenizer.nextToken();
			rows.push(row);
		}
		
		for (String row : rows) {
			for (int index = 0; index < columns.length; index++) {
				if (index >= row.length()) {
					logger.warn("Given row '"+ row + "' is shorter then defined width.");
					continue;
				}
				
				String boxTypeStr = row.substring(index, index + 1);
				if (! boxTypeStr.equals(".")) {
					try {
						BoxType boxType = BoxType.valueOf(boxTypeStr.toUpperCase());
						Box box = BoxFactory.create(boxType);
						columns[index].put(box);
					}
					catch (IllegalArgumentException iae) {
						logger.warn("Unknown box type '" + boxTypeStr + "'", iae);
					}
				}
			}
		}
	}


	@Override
	public String toString() {
		LinkedList<String> rows = new LinkedList<>();
		for (int rowNo = 0; rowNo < getHeigth(); rowNo++) {
			StringBuilder bldr = new StringBuilder();
			for (int columnNo = 0; columnNo < columns.length; columnNo++) {
				Box box = columns[columnNo].peek(rowNo);
				if (box == null) {
					bldr.append(".");
				}
				else {
					bldr.append(box.getType().name());
				}
			}
			bldr.append("\n");
			rows.add(bldr.toString());
		}
		
		// Reverses the list internally
		Collections.reverse(rows);
		StringBuilder bldr = new StringBuilder();
		for (String row : rows) {
			bldr.append(row);
		}
		return bldr.toString();
	}


	private int getHeigth() {
		return columns[0].getCapacity();
	}

}
