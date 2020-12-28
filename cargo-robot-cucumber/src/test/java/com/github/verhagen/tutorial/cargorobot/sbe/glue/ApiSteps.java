package com.github.verhagen.tutorial.cargorobot.sbe.glue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiSteps implements Steps {
	private Logger logger = LoggerFactory.getLogger(ApiSteps.class);

	
	@Override
	public void starting_the_game(String levelName, String challengeName) {
		logger.info("   starting_the_game( " + levelName + " , " + challengeName + " )");
		
	}

	@Override
	public void adding_program(String register, String commands) {
		logger.info("   adding_program( " + register + " , " + commands + " )");
	}

	@Override
	public void executing_the_program() {
		logger.info("   executing_the_program()");
	}

	@Override
	public void goal_should_be_reached() {
		logger.info("   goal_should_be_reached()");
	}

	@Override
	public void thiss() {
		logger.info("   thiss()");
	}

	@Override
	public void that() {
		logger.info("   that()");
	}

	@Override
	public void give_hints() {
		logger.info("   give_hints()");
	}

}
