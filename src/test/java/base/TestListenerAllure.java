package base;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.extension.*;

import java.nio.charset.StandardCharsets;

public class TestListenerAllure extends AllureJunit5 implements TestWatcher, BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private static final ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        startTime.set(System.currentTimeMillis());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        long duration = System.currentTimeMillis() - startTime.get();
        Allure.addAttachment("Test Duration", duration + " ms");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Object testInstance = context.getRequiredTestInstance();

        if (testInstance instanceof BaseTest baseTest) {
            Page page = baseTest.page;

            // Attach screenshot
            byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
            Allure.getLifecycle().addAttachment(
                    "Screenshot on Failure", "image/png", "png", screenshot
            );

            // Attach HTML source
            String pageSource = page.content();
            Allure.addAttachment("Page Source", "text/html", pageSource, ".html");

            // Optional: Add console logs, network logs, trace, etc.
        }
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        Allure.addAttachment("Status", "Test passed successfully!");
    }
}