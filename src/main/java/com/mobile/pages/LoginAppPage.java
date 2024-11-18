package com.mobile.pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginAppPage {

	AppiumDriver<MobileElement> driver;
	
	public LoginAppPage(AppiumDriver<MobileElement> driver) {
		 this.driver = driver;
	}
	
	public void LoginMonileApp() throws Exception {
		driver.findElement(MobileBy.className("android.widget.Button")).click();
		Thread.sleep(5000);
		WebElement element = driver.findElement(MobileBy.className("android.widget.EditText"));
		element.click();
		element.sendKeys("6010001000");
		driver.findElement(MobileBy.AccessibilityId("Get OTP")).click();
		Thread.sleep(10000);
		for(int i=6;i<=10;i++) {
			String a = "1" ,b = "2", c = "3", d = "4";
			WebElement otp_Box =driver.findElement(MobileBy.xpath("//android.widget.EditText[@index='"+i+"']"));
			otp_Box.click();
			if(i==6) {
				otp_Box.sendKeys(a);
			}else if(i==7) {
				otp_Box.sendKeys(b);
			}else if(i==8) {
				otp_Box.sendKeys(c);i++;			
			}else if(i==10) {
				otp_Box.sendKeys(d);
			}
		}
		Thread.sleep(5000);
		WebElement testmsg = driver.findElement(MobileBy.AccessibilityId("Hello Aran"));
		String nameOfText = testmsg.getTagName();
		System.out.println("Test message Name : " + nameOfText);
		Assert.assertTrue(testmsg.isDisplayed());
		//Img Assertion
		WebElement img = driver.findElement(MobileBy.xpath("(//android.widget.ImageView[@index='3' and @resource-id])[1]"));
		Assert.assertTrue(img.isDisplayed(), "If Element is Visible Then text Script will pass Successfully");
		
		WebElement school = driver.findElement(MobileBy.AccessibilityId("TestPerform School"));
		String schoolname = school.getTagName();
		System.out.println("schoolname : " +schoolname);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Assert.assertEquals(schoolname, "TestPerform School");
		
		driver.findElement(MobileBy.AccessibilityId("Students")).click();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		driver.findElement(MobileBy.AccessibilityId("Play school")).click();
	}
}
