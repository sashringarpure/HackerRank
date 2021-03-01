package hackerRank;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.testng.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Helper {

    private WebDriver drv;

    public Helper(WebDriver driver) {
        this.drv = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Verify if a webElement object exist
     *
     */
    public boolean verifyObjectExist(WebElement wl) {
        waitForObjectVisible(
                wl,
                20
        );
        return wl.isDisplayed();
//        Assert.assertTrue(wl.isDisplayed());
    }

    /**
     * Method to wait for element to be visible
     *
     */
    public void waitForObjectClikable(WebElement wl, int timeInSec) {
        WebDriverWait wait = new WebDriverWait(drv, timeInSec);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(wl));
        } catch (Exception e) {
            Assert.fail("Object: " + wl.getText() + " not found!");
        }
    }

    /**
     * method to wait for webelement to be visible
     * @param wl
     * @param timeInSec
     */
    public void waitForObjectVisible(WebElement wl, int timeInSec) {
        WebDriverWait wait = new WebDriverWait(drv, timeInSec);
        try {
            wait.until(ExpectedConditions.visibilityOf(wl));
        } catch (Exception e) {
            Assert.fail("Object: " + wl.getText() + " not found!");
        }
    }


    /**
     * Method to click on object
     *
     */
    public void clickObject(WebElement wl) {
        waitForObjectVisible(wl, 10);
        wl.click();
    }

    /**
     * Verify if a URL has changed
     *
     */
    public boolean hasUrlChanged(String oldUrl) {
        boolean hasChanged = false;
        String currentUrl = null;
        do {
            drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            currentUrl = drv.getCurrentUrl();
        } while (currentUrl.equals(oldUrl));
        if (!currentUrl.equals(oldUrl))
            hasChanged = true;
        return hasChanged;
    }

    /**
     * method to enter text in webelement
     * @param wl
     * @param value
     */
    public void enterValue(WebElement wl, String value) {

        waitMilliSeconds(1000);
        waitForObjectVisible(wl, 15);
        wl.clear();
        wl.sendKeys(value);
        waitMilliSeconds(1000);
    }

    /*

    Method to enter value in the web element.

     */
    public void enterValue(WebElement wl, Keys keys) {

        waitForObjectVisible(wl, 15);
        //wl.clear();
        wl.sendKeys(keys);
        waitMilliSeconds(1000);
    }

    public void waitMilliSeconds(int milliSec){
        try{
            Thread.sleep(milliSec);
        }catch(Exception e){
            e.printStackTrace();

        }
    }

    /**
     * Method to take screenshot
     * @param scrName
     */
    public void screenShot(String scrName) {

        try {
            File scrFile = ((TakesScreenshot) drv).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("test/screenshots/" + scrName + ".png"));
            System.out.println("Screen captured!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*

    Method to hover mouse on the web element.

     */
    public void mouseHover(WebElement element) {

        Actions builder = new Actions(this.drv);
        builder.moveToElement(element).build().perform();
    }

    /*

    Method to move mouse to a web element.

     */
    public void moveTo(WebElement element) {

        Actions builder = new Actions(this.drv);
        builder.moveToElement(element).click().perform();
    }

    /*

    Method to retrieve text from the web element.

     */
    public String getText(WebElement element) {
        waitForObjectVisible(element, 10);
        return element.getText();
    }

    /*

    Method to maximize browser.

     */
    public void maximizeBrowser() {

        this.drv.manage().window().maximize();
    }


}

