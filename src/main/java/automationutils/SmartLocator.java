package automationutils;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class SmartLocator {
    private final Page page;
    private final String[] strategies;

    public SmartLocator(Page page, String... strategies) {
        this.page = page;
        this.strategies = strategies;
    }

    public Locator find() {
        for (String strategy : strategies) {
            try {
                Locator locator = page.locator(strategy);
                if (locator.count() > 0) {
                    return locator;
                }
            } catch (Exception ignored) {}
        }
        throw new RuntimeException("No valid locator found");
    }
}

//Example Usage:
//SmartLocator loginButton = new SmartLocator(page,
//        "role=button[name='Login']",
//        "text=Login",
//        "css=.login-btn"
//);
//loginButton.find().click();
