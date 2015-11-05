package com.github.verhagen.tutorial.cargorobot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Crane {
	private final Logger logger = LoggerFactory.getLogger(Crane.class);
	private final int railLength;
	private int location;
	private final int locationMin = 0;
	private final int locationMax;


	public Crane(int railLength) {
		this(railLength, 0);
	}

	public Crane(int railLength, int locationOnRail) {
		if (locationOnRail < 0) {
			throw new IllegalArgumentException("Argument 'locationOnRail', with value '" + 
					locationOnRail + "' is before start of rail. The rail starts at '0'.");
		}
		if (locationOnRail >= railLength) {
			throw new IllegalArgumentException("Argument 'locationOnRail', with value '" + 
					locationOnRail + "' is beyound end of rail. The rail end at '"
					+ (railLength - 1) + "'");
		}
		this.railLength = railLength;
		this.location = locationOnRail;
		this.locationMax = railLength -1;
	}

	public void moveLeft() {
		if (location == locationMin) {
			logger.warn("Can not move left.");
			return;
		}

		--location;
	}

	public void moveRight() {
		if (location == locationMax) {
			logger.warn("Can not move right.");
			return;
		}

		++location;
	}


	private int getLocation() {
		return location;
	}

	public void moveDown() {
		// TODO Auto-generated method stub
		
	}
	
}
