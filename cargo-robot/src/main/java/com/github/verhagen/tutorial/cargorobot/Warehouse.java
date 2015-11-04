package com.github.verhagen.tutorial.cargorobot;

import java.util.StringTokenizer;

public class Warehouse {
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
		while (tokenizer.hasMoreTokens()) {
			String row = tokenizer.nextToken();
			for (int index = 1; index <= row.length(); index++) {
				String packageId = row.substring(0, index);
				
				
//				char packageId = token.  .charAt(index);
//				switch (packageId) {
//					case 'A':
//						break;
//					case '':
			}
		}
	}


}
