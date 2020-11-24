package com.github.verhagen.tutorial.cargorobot.core;

import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.FeatureManagerBuilder;
import org.togglz.core.repository.mem.InMemoryStateRepository;
import org.togglz.core.user.NoOpUserProvider;

import com.github.verhagen.tutorial.cargorobot.CargoRobotFeatures;

public class Warehouse {
	private final Logger logger = LoggerFactory.getLogger(Warehouse.class);
	private final String originalFilling;
	private final Crane crane;
	private final Column[] columns;
	private final BoxFactory boxFactory = new BoxFactory();

	
	public Warehouse(int width, int heigth, String filling) {
		this.originalFilling = filling;

		columns = new Column[width];
		for (int columnNo = 0; columnNo < width; columnNo++) {
			columns[columnNo] = new Column(heigth);
		}
		crane = new Crane(this, width);

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
	public void reset() {
		clear();
//		boxFactory.reset();

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
				if (! (".".equals(boxTypeStr) || " ".equals(boxTypeStr))) {
					try {
						BoxType boxType = BoxType.valueOf(boxTypeStr.toUpperCase());
						Box box = boxFactory.create(boxType);
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


	public int getWidth() {
		return columns.length;
	}

	public int getHeigth() {
		return columns[0].getCapacity();
	}

	public void putBox(int colNo, Box box) {
		columns[colNo].put(box);
	}

	public Box getBox(int colNo) {
		return columns[colNo].get();
	}

	public void execute(final String commandStr) {
		for (int index = 0; index < commandStr.length(); ++index) {
			
			switch (commandStr.charAt(index)) {
				case 'R':
					crane.moveRight();
					break;
				case 'L':
					crane.moveLeft();
					break;
				case 'D':
					crane.moveDown();
					break;
				default:
					logger.warn("The crane will ignore the given command '" + commandStr.charAt(index) + "'.");
			}
		}
	}


	public boolean isCapacityAvailable(int location) {
		return columns[location].isCapacityAvailable();
	}

	public String getCraneStatus() {
		return crane.toString();
	}

}
