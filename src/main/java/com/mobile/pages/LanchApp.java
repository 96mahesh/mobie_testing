package com.mobile.pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LanchApp {
	
	AppiumDriver<MobileElement> driver;

	@Test	
	public void setUp() throws MalformedURLException, Exception  {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "UIAutomator2");
	  	capabilities.setCapability("platformName", "Android");
	  	capabilities.setCapability("deviceName", "emulator-5554");
		//capabilities.setCapability("deviceName", "RZ8N81T1L3B");
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("app","C:\\Users\\Admin\\Downloads\\Patasala school stage.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
		Thread.sleep(15000);
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
		Thread.sleep(10000);
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
		
		Thread.sleep(2000);
		MobileElement std_Tag = driver.findElement(MobileBy.xpath("//android.view.View[@index='1']"));
		Thread.sleep(2000);
		String Std_Lable = std_Tag.getTagName();
		System.out.println(Std_Lable);
		Assert.assertEquals(Std_Lable, "Students");
		
		Thread.sleep(5000);
		driver.findElement(MobileBy.AccessibilityId("Select class")).click();
		Thread.sleep(2000);
		
		//capturing the all the Elements 
		//AndroidElement list = (AndroidElement) driver.findElements(MobileBy.className("android.view.View"));
		
//        List<MobileElement> options=driver.findElements(MobileBy.className("android.view.View"));
//        for(WebElement e:options)
//	        {
//	            String val=e.getTagName();
//	            System.out.println(val);
//	            Thread.sleep(1000);
	        
		//scrolling Down Still We Get The Element
		
		MobileElement listitem = (MobileElement)driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelecter()).scrollIntoView("
		          +"new UiSelector().description(\"Sr. MEC\"));"));
		
		//driver.elementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"1,000,000\").instance(0))")
		
	//	System.out.println("All List Item : "+list);
//		System.out.println(listitem.getLocation());
//		listitem.click();
//		
//	        }
//	        List<MobileElement> options=driver.findElements(MobileBy.className("android.view.View"));
//	        System.out.println("Total number of options available in dropdown:"+options.size());
//	        for(WebElement e:options)
//	        {
//	            String val=e.getTagName();
//	            System.out.println(val);
//	            Thread.sleep(1000);
//	           
//	            if(val.equalsIgnoreCase("Jr. MPC"))
//	            {
//	            	MobileElement ele = driver.findElementByAccessibilityId("LKG");
//	            	//MobileElement elementToSwipe = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(9))")).click;
//	            	//driver.findElementByCssSelector("new UiScrollable(new    UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"WebView\").instance(0))").click();
//	            	//"new UiScrollable(new UiSelector().scrollable(true).instance(0))"   Jr. MPC
////	            	int startX = elementToSwipe.getLocation().getX() + elementToSwipe.getSize().getWidth() / 2;
////	            	int startY = elementToSwipe.getLocation().getY() + elementToSwipe.getSize().getHeight() / 2;
////	            	int endX = startX;
////	            	int endY = startY - 200;
//	            	
//	            	TouchActions action = new TouchActions(driver);
//	            	action.scroll(ele, 10, 300);
//	            	action.scroll(10, 300);
//	            	action.perform();
////	            	
////	            	TouchAction touchAction = new TouchAction(driver);
////	            	touchAction.press(ElementOption.element(elementToSwipe, startX, startY)).moveTo(ElementOption.point(endX, endY)).release().perform();
////	                e.click();
////	                break;
//	            }
//	        }
		
	//	driver.findElementByAccessibilityId("LKG").click();
		//driver.findElementByAccessibilityId("Sec A").click();
		Thread.sleep(3000);
		MobileElement refressBtn = driver.findElementsByClassName("android.view.View").get(4);
		refressBtn.click(); 
		
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.ImageView[@index='0']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.Button[@index='5']").click();
		
		driver.findElementByAccessibilityId("Take Photo").click();
		Thread.sleep(2000);
	    driver.findElementByAccessibilityId("Rotate").click();
	    //Photo
	    Thread.sleep(2000);
	    driver.findElementByXPath("//android.widget.Button[@index='3']").click();
	    Thread.sleep(2000);
	    driver.findElementByXPath("//android.widget.Button[@content-desc='Confirm']").click();
	    Thread.sleep(2000);
	    driver.findElementByAccessibilityId("Submit").click();
	    Thread.sleep(2000);
	    driver.findElementByXPath("//android.widget.Button[@content-desc='Change photo']").click();
	    Thread.sleep(2000);
	    driver.findElementByXPath("//android.widget.Button[@content-desc='Remove photo']").click();
	    
	
		
	}

}
