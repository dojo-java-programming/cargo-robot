package com.github.verhagen.tutorial.cargorobot;

import java.util.LinkedList;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Warehouse {
	private final Logger logger = LoggerFactory.getLogger(Warehouse.class);
	private final int width;
	private final int heigth;
	private final String originalFilling;
	private final Crane crane;
	private final Column[] columns;

	
	public Warehouse(int width, int heigth, String filling) {
		this.width = width;
		this.heigth = heigth;
		this.originalFilling = filling;

		crane = new Crane(width);
		columns = new Column[width];
		for (int columnNo = 0; columnNo < width; columnNo++) {
			columns[columnNo] = new Column(heigth);
		}

		StringTokenizer tokenizer = new StringTokenizer(filling, "\n");
		LinkedList<String> rows = new LinkedList<>(); 
		while (tokenizer.hasMoreTokens()) {
			String row = tokenizer.nextToken();
			rows.push(row);
		}
		
		for (String row : rows) {
			for (int index = 0; index < width; index++) {
				if (index >= row.length()) {
					logger.warn("Given row '"+ row + "' is shorter then defined width.");
					continue;
				}
				
				String boxTypeStr = row.substring(index, index + 1);
				if (! boxTypeStr.equals(" ")) {
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
		StringBuilder bldr = new StringBuilder();
		for (int rowNo = 0; rowNo < heigth; rowNo++) {
			for (int columnNo = 0; columnNo < columns.length; columnNo++) {
				Box box = columns[columnNo].peek(heigth);
				if (box == null) {
					bldr.append(" ");
				}
				else {
					bldr.append(box.getType().name());
				}
			}
			bldr.append("\n");
		}
		return bldr.toString();
	}

}
