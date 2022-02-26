package com.ui.stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.framework.actions.BaseAbstract;
import com.framework.actions.ScreenShotMethods;
import com.framework.commonutils.PropertiesFile;
import com.framework.initialization.DriverInitalization;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseAbstract {

	DriverInitalization driverInitialize = new DriverInitalization();
	protected static final Map<String, String> CONFIG_DETAILS = new HashMap<>();
	public static final String CONFIG_PATH = "\\Confguration.properties";
	ScreenShotMethods takeScreenShotObj = new ScreenShotMethods();

	static {

		CONFIG_DETAILS.put("Browser", PropertiesFile.getPropertyValue(CONFIG_PATH, "Browser"));

	}

	@Before
	public void beforeScenario(Scenario scenario) {

		driver = driverInitialize.getDriver(CONFIG_DETAILS);

	}

	@After
	public void afterScenario(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {

			takeScreenShotObj.takeScreenShot();
		}
		closeDriver();

	}
}
