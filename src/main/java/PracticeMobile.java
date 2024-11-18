import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class PracticeMobile {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9");
		dc.setCapability("deviceName", "Android");
		dc.setCapability("udid", "emulator-5554");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("autoGrantPermissions", true);
		dc.setCapability("app",
				"C:\\Users\\Admin\\Downloads\\Patasala school stage.apk");

		URL url = new URL("http://127.0.0.1:4723");

		AppiumDriver driver = new AppiumDriver(url, dc);
		driver.findElementById("com.android.permissioncontroller:id/permission_allow_button").click();
	}
}
