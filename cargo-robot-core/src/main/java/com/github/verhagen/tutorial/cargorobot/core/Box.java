package com.github.verhagen.tutorial.cargorobot.core;

public class Box {
	private final BoxType type;
	private final int serialNo;


	public Box(final BoxType type, final int serialNo) {
		this.type = type;
		this.serialNo = serialNo;
	}


	public BoxType getType() {
		return type;
	}

	public int getSerialNo() {
		return serialNo;
	}

}
