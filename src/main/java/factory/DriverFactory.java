// src/main/java/factory/DriverFactory.java
package factory;

import com.microsoft.playwright.*;

public class DriverFactory {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    public Page initializeDriver(String browserType, boolean headless) {
        playwright = Playwright.create();

        switch (browserType.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            default:
                throw new IllegalArgumentException("Invalid browser type: " + browserType);
        }

        context = browser.newContext();
        page = context.newPage();
        return page;
    }

    public void quit() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}