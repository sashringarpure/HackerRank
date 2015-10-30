package hackerRank;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class BrowserStack {

	public static final String userName = "shaileshshringar1";
	public static final String automateKey = "P5giyoxg1abEqftq7prN";
	public static final String URL = "http://"+userName+":"+automateKey+"@hub.browserstack.com/wd/hub";
	
	public static void main(String[] args) throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "44.0");
		caps.setCapability("os", "OSX");
		caps.setCapability("os_version", "Yosemite");
		caps.setCapability("browserstack.debug", true);
		caps.setCapability("browserstack.local", true);
		System.out.println(caps.toString());
		RemoteWebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.get("http://qc3-www.fanatics.corp/");
		System.out.println(driver.getTitle());
		driver.quit();
	}
 }
