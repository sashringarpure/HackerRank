package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import io.qameta.allure.Step;

public class VeraLISLoginPage {

        private final Page page;
        private final Locator userName;
        private final Locator pwd;

        public VeraLISLoginPage(Page page) {
            this.page = page;
            this.userName = page.locator("//*[@id='vaadinLoginUsername']/input");
            this.pwd = page.locator("xpath=//*[@id='vaadinLoginPassword']/input");
        }

        @Step("Navigate to VeraLIS Login Page")
        public void navigate(String url) {
            page.navigate(url);
        }

        @Step("Search for '{query}'")
        public void login(String user, String password) {
            userName.fill(user);
            pwd.fill(password);
            page.keyboard().press("Enter");
        }

        @Step("Get page title")
        public String getTitle() {
            page.waitForLoadState(LoadState.NETWORKIDLE);
            return page.title();
        }

}
