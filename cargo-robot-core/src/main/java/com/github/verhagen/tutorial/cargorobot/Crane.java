package com.github.verhagen.tutorial.cargorobot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Crane {
	private final Logger logger = LoggerFactory.getLogger(Crane.class);
	private int location;
	private final int locationMin = 0;
	private final int locationMax;
	private final Warehouse warehouse;
	private Box box;


	public Crane(Warehouse warehouse, int railLength) {
		this(warehouse, railLength, 0);
	}

	public Crane(Warehouse warehouse, int railLength, int locationOnRail) {
		if (locationOnRail < 0) {
			throw new IllegalArgumentException("Argument 'locationOnRail', with value '" + 
					locationOnRail + "' is before start of rail. The rail starts at '0'.");
		}
		if (locationOnRail >= railLength) {
			throw new IllegalArgumentException("Argument 'locationOnRail', with value '" + 
					locationOnRail + "' is beyound end of rail. The rail end at '"
					+ (railLength - 1) + "'");
		}
		this.warehouse = warehouse;
		this.location = locationOnRail;
		this.locationMax = railLength -1;
	}

	public void moveLeft() {
		--location;
		if (location < locationMin) {
			throw new CraneException("Crane is derailed on the left of it's rail.");
		}
	}

	public void moveRight() {
		++location;
		if (location > locationMax) {
			throw new CraneException("Crane is derailed on the right of it's rail.");
		}
	}


	public void moveDown() {
		if (box == null) {
			box = warehouse.getBox(location);
		}
		else if (warehouse.isCapacityAvailable(location)) {
			warehouse.putBox(location, box);
			box = null;
		}
	}

	@Override
	public String toString() {
		StringBuilder bldr = new StringBuilder();
		bldr.append("location '").append(location).append("'  ");
		if (box == null) {
			bldr.append("no box");
		}
		else {
			bldr.append("box: '").append(box.getType()).append("'  box-number: '").append(box.getSerialNo()).append("'");
		}
		return bldr.toString();
	}

}
