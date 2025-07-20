package hackerRank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SeleniumTestNG {

    @Test
    public void sampleTest() {
        System.out.println("HW");
        // Automatically download the correct ChromeDriver
        WebDriverManager.chromedriver().setup();
        // Set Chrome options
        ChromeOptions options = new ChromeOptions();
        // You can add arguments like "--headless" or "--start-maximized"
        options.addArguments("--start-maximized");
        //options.setBinary("C:\\Users\\shailesh.shringarpur\\Downloads\\shailesh\\ChromeStandaloneSetup64.exe");
        // Create WebDriver with options
        WebDriver driver = new ChromeDriver(options);
        // Sample automation
        driver.get("https://www.google.com");
        PageObject page = new PageObject(driver);
        page.Search("test");
        //Assert.assertEquals("test - Google Search", page.getPageTitle());
        System.out.println(page.getPageTitle());
        // Close browser
        driver.quit();
    }
}
