package com.github.verhagen.tutorial.cargorobot;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoxTest {

	@Test
	public void createBox() throws Exception {
		Box boxA1 = BoxFactory.create(BoxType.A);
		Box boxA2 = BoxFactory.create(BoxType.A);
		
		Assert.assertNotEquals(boxA1, boxA2);

		Box boxB1 = BoxFactory.create(BoxType.B);
		Assert.assertNotEquals(boxA1, boxB1);
	}

}
