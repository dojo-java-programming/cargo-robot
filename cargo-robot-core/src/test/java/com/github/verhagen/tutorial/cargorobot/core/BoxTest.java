package com.github.verhagen.tutorial.cargorobot.core;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoxTest {
	private BoxFactory boxFactory = new BoxFactory();

	@Test
	public void createBox() throws Exception {
		Box boxA1 = boxFactory.create(BoxType.A);
		Box boxA2 = boxFactory.create(BoxType.A);
		
		Assert.assertNotEquals(boxA1, boxA2);

		Box boxB1 = boxFactory.create(BoxType.B);
		Assert.assertNotEquals(boxA1, boxB1);
	}

}
