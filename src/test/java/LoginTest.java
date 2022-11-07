import Browsers.FireFoxBrowser;
import Pages.AuthenticationPage;
import Pages.IndexPage;
import Pages.MyAccountPage;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class LoginTest {

    private final static String URL = ("http://automationpractice.com/index.php");
    private static WebDriver driver;
    private static byte[] screenshot;
    private IndexPage indexPage;
    private AuthenticationPage authenticationPage;
    private final static String EMAIL_AND_PASSWORD = "{33@33.rrr, 1qaz!QAZ}";

    @BeforeEach
    void setup() {
        driver = FireFoxBrowser.getInstance().getWebDriver();
        driver.get(URL);
        indexPage = new IndexPage(driver);
        authenticationPage = indexPage.clickSignInButton();
    }

    @ParameterizedTest
    @CsvSource(EMAIL_AND_PASSWORD)
    void loginTest(String email, String password){
        MyAccountPage myAccountPage = authenticationPage.login(email, password);
        Assertions.assertTrue(myAccountPage.isUserLoggedIn());
    }

    @AfterEach
    void cleanup() {
        screenshot = TestListener.makeScreenshot();
        driver.close();
    }

    public static class TestListener implements TestWatcher {

        @Override
        public void testFailed(ExtensionContext context, Throwable cause) {
            if (context.getExecutionException().isPresent()) {
                Allure.addByteAttachmentAsync(
                        "Page screenshot",
                        "image/png",
                        () -> screenshot
                );
            }
        }

        @Attachment(value = "Page Screenshot", type = "image/png")
        private static byte[] makeScreenshot() {
            return ((TakesScreenshot) FireFoxBrowser.getInstance().getWebDriver()).getScreenshotAs(OutputType.BYTES);
        }
    }
}
