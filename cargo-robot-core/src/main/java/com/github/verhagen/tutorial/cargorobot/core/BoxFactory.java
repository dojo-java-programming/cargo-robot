package com.github.verhagen.tutorial.cargorobot.core;

public class BoxFactory {
	private int serialNo = 0;


	public Box create(final BoxType type) {
		return new Box(type, serialNo++);
	}

}
