package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class GoogleHomePage {
    private final Page page;
    private final Locator searchBox;
    private final Locator searchButton;

    public GoogleHomePage(Page page) {
        this.page = page;
        this.searchBox = page.locator("textarea#APjFqb.gLFyf");
        this.searchButton = page.locator("input[name='btnK']").first();
    }

    @Step("Navigate to Google homepage")
    public void navigate() {
        page.navigate("https://www.google.com");
    }

    @Step("Search for '{query}'")
    public void search(String query) {
        searchBox.fill(query);
        page.keyboard().press("Enter");
    }

    @Step("Get page title")
    public String getTitle() {
        return page.title();
    }
}
