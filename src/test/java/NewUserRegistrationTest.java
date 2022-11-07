import Browsers.ChromeBrowser;
import Pages.AuthenticationPage;
import Pages.IndexPage;
import Pages.MyAccountPage;
import Pages.RegistrationPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


@Epic("Login and logout tests")
@Feature("Login and logout tests")
@ExtendWith(NewUserRegistrationTest.TestListener.class)
public class NewUserRegistrationTest {

    private final static String URL = ("http://automationpractice.com/index.php");
    private static WebDriver driver;
    private static byte[] screenshot;
    private IndexPage indexPage;
    private AuthenticationPage authenticationPage;
    private final static String CSV_FILE_NAME = "src/test/NewUserFile/users.csv";


    @BeforeEach
    void setup() {
        driver = ChromeBrowser.getInstance().getWebDriver();
        driver.get(URL);
        indexPage = new IndexPage(driver);
        authenticationPage = indexPage.clickSignInButton();

    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/newUser.csv")
    @Description("Verification of new user registration ability")
    @Story("Register new user")
    void registerNewUserTest(@AggregateWith(UserAggregator.class) User user) {
        RegistrationPage registrationPage = authenticationPage.createAccount(user.getEmail());
        MyAccountPage myAccountPage = registrationPage
                .registerNewUser(user.getFirstName(), user.getLastName(), user.getPassword(), user.getAddress(),
                        user.getCity(), user.getState(), user.getPostcode(), user.getMobilePhone());
        Assertions.assertTrue(myAccountPage.isUserRegistered());
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
            return ((TakesScreenshot) ChromeBrowser.getInstance().getWebDriver()).getScreenshotAs(OutputType.BYTES);
        }
    }
}


