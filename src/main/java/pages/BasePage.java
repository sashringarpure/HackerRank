// src/main/java/pages/BasePage.java
package pages;

import com.microsoft.playwright.Page;

public class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public void navigate(String url) {
        page.navigate(url);
    }

    public String getTitle() {
        return page.title();
    }

    public void click(String selector) {
        page.click(selector);
    }

    public void type(String selector, String text) {
        page.fill(selector, text);
    }

    public String getText(String selector) {
        return page.textContent(selector);
    }

    public boolean isVisible(String selector) {
        return page.isVisible(selector);
    }
}