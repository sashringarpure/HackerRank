package pages;

import com.microsoft.playwright.Page;

public class PageFactory {
    public static GoogleHomePage googleHome(Page page) {
        return new GoogleHomePage(page);
    }

    public static VeraLISLoginPage veraLISLogin(Page page) {
        return new VeraLISLoginPage(page);
    }

    public static VeraLISCreateAccessionPage veraLISCreateAccession(Page page) {
        return new VeraLISCreateAccessionPage(page);
    }

}
