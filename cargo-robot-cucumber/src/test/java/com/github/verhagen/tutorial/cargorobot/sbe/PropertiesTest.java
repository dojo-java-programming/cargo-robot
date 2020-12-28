package com.github.verhagen.tutorial.cargorobot.sbe;

import static org.junit.Assert.assertEquals;

import java.io.FileReader;
import java.nio.file.Paths;
import java.util.Properties;

import org.junit.Test;


public class PropertiesTest {

	@Test
	public void loadProperties() throws Exception {
		Properties properties = new Properties();
		properties.load(new FileReader(Paths.get("src/test/resources/webdrivermanager.properties").toFile()));
		
		assertEquals("https://chromedriver.storage.googleapis.com/", properties.getProperty("wdm.chromeDriverUrl"));
	}
}
