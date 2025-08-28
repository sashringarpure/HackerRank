package tests;

import base.BaseTest;
import base.TestListenerAllure;
import com.microsoft.playwright.options.LoadState;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.VeraLISLoginPage;
import pages.VeraLISCreateAccessionPage;
import pages.PageFactory;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TestListenerAllure.class)
@Tag("VeraLIS-create-accession")
public class VeraLISCreateAccessionTest extends BaseTest{
    VeraLISLoginPage veralisLoginPage;
    VeraLISCreateAccessionPage veraLISCreateAccessionPage;
    String env = "http://aws-apx1-qa.qa-lis.veracyte.lan:8090";
    String loginURL = "/login";
    String createAccessionURL = "/afirma-create-accession";

    @BeforeEach
    void setup() {
        veralisLoginPage = PageFactory.veraLISLogin(page);
        veraLISCreateAccessionPage = PageFactory.veraLISCreateAccession(page);
    }

    @Test
    @Owner("SS")
    @Severity(SeverityLevel.CRITICAL)
    void testCreateAccession() throws InterruptedException {
        veralisLoginPage.navigate(env+loginURL);
        veralisLoginPage.login("shailesh.shringarpur", "Red@pple94536#");
        page.waitForLoadState(LoadState.NETWORKIDLE);
        veralisLoginPage.navigate(env+createAccessionURL);
        veraLISCreateAccessionPage.createAccession();
        assertTrue(veralisLoginPage.getTitle().contains("Create Accession"));
    }
}