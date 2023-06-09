package com.ASI.step_definitions;


import com.ASI.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;


public class Hooks {

	@Before("@db")
	public void dbHook() {
		System.out.println("---> HOOKS --->creating database connection");

	}

	@After("@db")
	public void afterDbHook() {
		System.out.println("---> HOOKS ---> closing database connection");

	}
	
	@Before("@ui")
	public void setUp() {

		Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.get().manage().window().maximize();

	}
	
	@After("@ui")
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {

			final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png","screenshot");
		}
		Driver.closeDriver();
	}
	
	
	
	
	
}
