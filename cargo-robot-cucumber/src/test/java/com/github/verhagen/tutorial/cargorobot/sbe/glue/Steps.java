package com.github.verhagen.tutorial.cargorobot.sbe.glue;


public interface Steps {

//	@Given("starting the game {string}")
	void starting_the_game(String levelName, String challengeName);

//	@When("adding program {string}")
	void adding_program(String register, String commands);

//	@When("executing the program")
	void executing_the_program();

//	@Then("goal should be reached")
	void goal_should_be_reached();

//	@Given("this")
	void thiss();

//	@When("that")
	void that();

//	@Then("giving hints")
	void give_hints();

}