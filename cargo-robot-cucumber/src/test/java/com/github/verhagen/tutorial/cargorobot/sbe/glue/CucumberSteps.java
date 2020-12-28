package com.github.verhagen.tutorial.cargorobot.sbe.glue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class CucumberSteps {
	private final Logger logger = LoggerFactory.getLogger(CucumberSteps.class);

	private Steps steps = new ApiSteps();
//	private Steps steps = new CargoRobotFrontEnd();

	@Given("starting the level {string} with challenge {string}")
	public void starting_the_game(String levelName, String challengeName) {
		logger.info("starting the game {0}", levelName);
		steps.starting_the_game(levelName, challengeName);
	}

	@When("programming {string} with the commands {string}")
	public void adding_program(String register, String commands) {
		logger.info("adding program to register {0} with command {1}", register, commands);
		steps.adding_program(register, commands);
	}

	@When("(executing|running) the program")
	public void executing_the_program() {
		logger.info("executing the program");
		steps.executing_the_program();
	}

	@Then("goal should be reached")
	public void goal_should_be_reached() {
		logger.info("goal should be reached");
		steps.goal_should_be_reached();
	}

	@Given("this")
	public void thiss() {
		logger.info("this");
		steps.thiss();
	}

	@When("that")
	public void that() {
		logger.info("that");
		steps.that();
	}

	@Then("giving hints")
	public void give_hints() {
		logger.info("giving hints");
		steps.give_hints();
	}

}
