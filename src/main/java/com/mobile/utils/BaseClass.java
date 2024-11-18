package com.mobile.utils;

import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class BaseClass {

	//AppiumDriver<WebElement> driver;
	public static AppiumDriver<MobileElement> driver;
	

	@BeforeTest
	public void setup() throws Exception {
		getAppiumDriver();
	}
	
	public AppiumDriver<MobileElement> getAppiumDriver() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "RZ8N81T1L3B"); 
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("app", "D:\\Downloads\\Patasala school stage.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		Thread.sleep(25000);
		return driver;
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
