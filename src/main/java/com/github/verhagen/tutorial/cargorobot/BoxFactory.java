package com.github.verhagen.tutorial.cargorobot;

public class BoxFactory {
	private static int serialNo = 0;


	public static Box create(BoxType type) {
		return new Box(type, serialNo++);
	}

}
