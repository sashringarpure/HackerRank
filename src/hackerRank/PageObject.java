package hackerRank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    WebDriver driver;
    // Factory pattern with @FindBy
    @FindBy(name = "q")
    WebElement searchTextBox;

    @FindBy(name = "btnK")
    WebElement searchButton;

    // Constructor: initializes elements
    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Search(String searchQuery) {
        searchTextBox.sendKeys(searchQuery);
        searchButton.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

}
