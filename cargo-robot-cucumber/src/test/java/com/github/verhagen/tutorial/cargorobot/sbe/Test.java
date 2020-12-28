package com.github.verhagen.tutorial.cargorobot.sbe;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(publish = false, dryRun = true, features = "src/test/resources")
public class Test {
	private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
    	WebDriverManager.globalConfig().setProperties("webdrivermanager.properties");
//        WebDriverManager.chromedriver().config().setProperties("src/test/resources/webdrivermanager.properties");
        WebDriverManager.chromedriver().setup();
    }


    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
}
