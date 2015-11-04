package com.github.verhagen.tutorial.cargorobot;

import org.testng.annotations.Test;

public class BoxTest {

	@Test
	public void createBox() throws Exception {
		Box boxA1 = BoxFactory.create(BoxType.A);
		Box boxB1 = BoxFactory.create(BoxType.B);
	}
}
