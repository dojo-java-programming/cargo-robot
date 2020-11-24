package com.github.verhagen.tutorial.cargorobot;

public class BoxFactory {
	private int serialNo = 0;


	public Box create(final BoxType type) {
		return new Box(type, serialNo++);
	}

}
