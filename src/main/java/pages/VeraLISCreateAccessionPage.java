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
        this.search = page.locator("xpath=//vaadin-vertical-layout[@class='app']")
                .locator("xpath=.//div[@class='app-content']")
                .locator("xpath=.//vaadin-vertical-layout[@class='create-accession-view']")
                .locator("xpath=.//vaadin-horizontal-layout").nth(1)
                .locator("xpath=.//vaadin-vertical-layout[@class='card-layout-simple']").first()
                .locator("xpath=.//vaadin-vertical-layout[@class='body']").first()
                .locator("xpath=.//vaadin-horizontal-layout").nth(2)
                .locator("xpath=.//vaadin-button/button");
    }

    @Step("Create Accession")
    public void createAccession() {
        page.waitForLoadState(LoadState.NETWORKIDLE);
        location.fill("VeracyteSSF");
        tracking.fill("n/a");
        lastName.fill("Doe");
        firstName.fill("Johnetta");
        dob.fill("04/11/2001");
        page.keyboard().press("Enter");
        gender.fill("Female");
        //page.keyboard().press("Enter");
        page.keyboard().press("Tab");
        //page.keyboard().press("Enter");
        Locator root = page.locator("xpath=//vaadin-vertical-layout[@class='app']");
        System.out.println(root.count()); // should be 1
        Locator content = root.locator("xpath=.//div[@class='app-content']");
        System.out.println(content.count()); // should be 1
        Locator createAccession = content.locator("xpath=.//vaadin-vertical-layout[@class='create-accession-view']");
        System.out.println(createAccession.count()); // should be 1
        Locator test1 = content.locator("xpath=.//vaadin-horizontal-layout").nth(1);
        System.out.println(test1.count()); // should be 1
        Locator test2 = content.locator("xpath=.//vaadin-vertical-layout[@class='card-layout-simple']").first();
        System.out.println(test2.count()); // should be 1
        Locator test3 = content.locator("xpath=.//vaadin-vertical-layout[@class='body']").first();
        System.out.println(test3.count()); // should be 1
        Locator test4 = content.locator("xpath=.//vaadin-horizontal-layout").nth(2);
        System.out.println(test4.count()); // should be 1
        Locator test5 = content.locator("xpath=.//vaadin-button/button");
        System.out.println(test5.count()); // should be 1
        Locator fullChain = page.locator(
                "xpath=//vaadin-vertical-layout[@class='app']" +
                        "//div[@class='app-content']" +
                        "//vaadin-vertical-layout[@class='create-accession-view']" +
                        "//vaadin-horizontal-layout[2]" +
                        "//vaadin-vertical-layout[@class='card-layout-simple']" +
                        "//vaadin-vertical-layout[@class='body']" +
                        "//vaadin-horizontal-layout[3]" +  // nth(2) = [3] in XPath
                        "//vaadin-button/button"
        );
        System.out.println("full chain : " + fullChain.count());
        Locator searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search").setExact(true));
        searchButton.click();
        //search.click();
    }

    @Step("Get page title")
    public String getTitle() {
        page.waitForLoadState(LoadState.NETWORKIDLE);
        return page.title();
    }
}
