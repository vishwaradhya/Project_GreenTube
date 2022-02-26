package com.rest.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import com.framework.commonutils.Paths;
import com.framework.commonutils.PropertiesFile;
import com.framework.rest.RestImpl;
import com.jayway.restassured.response.Response;

import cucumber.api.java.en.Given;

public class GreenTubeRestStepDefinitions extends RestImpl {
	public static final String USERDATA_PATH = "\\userData.properties";
	public static final String BASE_URL;
	public static final String APP_ID = "";
	public static Response httpResponse;
	protected static Map<String, String> query = new HashMap<>();
	static {

		BASE_URL = PropertiesFile.getPropertyValue(USERDATA_PATH, "BASE_URL");
		query.put("apiKey", PropertiesFile.getPropertyValue(USERDATA_PATH, "APP_KEY"));
	}

	@Given("^user get the maps$")
	public void userGetMaps() {

		httpResponse = getRequestWithQueryParams(BASE_URL, Paths.MAPS_GET, query);

	}

	@Given("^user verifies the status code (\\d+)$")
	public void verifyStatusCode(int statusCode) {

		assertTrue("Respose Code not matched Expected " + statusCode + " Actual is " + httpResponse.getStatusCode(),
				httpResponse.getStatusCode() == statusCode);
	}
}
