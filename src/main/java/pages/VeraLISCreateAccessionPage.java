package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import io.qameta.allure.Step;

public class VeraLISCreateAccessionPage {

    private final Page page;
    private final Locator location;
    private final Locator tracking;
    private final Locator lastName;
    private final Locator firstName;
    private final Locator gender;
    private final Locator dob;
    private final Locator search;

    public VeraLISCreateAccessionPage(Page page) {
        this.page = page;
        this.location = page.locator("vaadin-combo-box[label='Location']").locator("input[role='combobox']");
        this.tracking = page.locator("vaadin-text-field").nth(0).locator("input");
        this.lastName = page.locator("vaadin-text-field[tabindex='11'] >> input");
        this.firstName = page.locator("vaadin-text-field[tabindex='12'] >> input");
        this.dob = page.locator("vaadin-date-picker[tabindex='13'] >> input");
        this.gender = page.locator("vaadin-text-field[tabindex='14'] >> input");
        this.search = page.locator("xpath=//vaadin-vertical-layout")
                .locator("xpath=.//div[@class='app-content']")
                .locator("xpath=.//vaadin-vertical-layout[@class='create-accession-view']")
                .locator("xpath=.//vaadin-horizontal-layout[2]")
                .locator("xpath=.//vaadin-vertical-layout[@class='card-layout-simple']")
                .locator("xpath=.//vaadin-vertical-layout[@class='body']")
                .locator("xpath=.//vaadin-horizontal-layout[3]")
                .locator("xpath=.//vaadin-button")
                .filter(new Locator.FilterOptions().setHasText("Search"))
                .locator("css=button[tabindex='0']");
    }

    @Step("Create Accession")
    public void createAccession() {
        page.waitForLoadState(LoadState.NETWORKIDLE);
        location.fill("VeracyteSSF");
        tracking.fill("n/a");
        lastName.fill("Doe");
        firstName.fill("Johnetta");
        gender.fill("Female");
        page.keyboard().press("ArrowDown");
        page.keyboard().press("Enter");
        System.out.println(search.count());
        search.click();
    }

    @Step("Get page title")
    public String getTitle() {
        page.waitForLoadState(LoadState.NETWORKIDLE);
        return page.title();
    }
}
