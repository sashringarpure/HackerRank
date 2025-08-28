package base;

import com.microsoft.playwright.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;
    protected Page page;
    protected BrowserContext context;

    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @AfterAll
    static void afterAll() {
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void beforeEach() {
            context = browser.newContext(new Browser.NewContextOptions()
                    .setRecordVideoDir(Paths.get("videos/")).setRecordVideoSize(1280, 720));
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));
            page = context.newPage();
        page.onConsoleMessage(msg -> {
            Allure.addAttachment("Console Log: " + msg.type(), msg.text());
        });
        }

    @AfterEach
    void afterEach(TestInfo testInfo) {
        context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("target/trace.zip")));
        // Attach trace.zip to Allure
        attachTrace("target/trace.zip");
        context.close();
        if (testInfo.getTags().contains("failed")) {
            byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
            saveScreenshot(screenshot);
        }
        context.close();
    }

    @Attachment(value = "Screenshot on failure", type = "image/png")
    private byte[] saveScreenshot(byte[] data) {
        return data;
    }

    @Attachment(value = "Playwright Trace", type = "application/zip")
    private byte[] attachTrace(String path) {
        try {
            return Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}