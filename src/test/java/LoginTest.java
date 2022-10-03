import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;

public class LoginTest {

    private final static String URL = ("https://mail.yandex.com/");
    private static final String LOGIN_AND_PASSWORD = "task30, task30task30";
    private static final String EXPECTED_TEXT_PART = "email with spam protection";
    private WebDriver webDriver;
    private StartPage startPage;

    @BeforeEach
    void setup() {
        Browser browser = Browser.getInstance();
        webDriver = browser.getWebDriver();
        webDriver.get(URL);
    }

    @ParameterizedTest
    @CsvSource(LOGIN_AND_PASSWORD)
    void loginToYandexMailTest(String login, String password) {
        startPage = new StartPage(webDriver);
        LoginPage loginPage = startPage.clickLoginButton();
        MailInboxPage mailInboxPage = loginPage.loginToMail(login, password);
        mailInboxPage.logout();
        Assertions.assertTrue(startPage.getH2Text().contains(EXPECTED_TEXT_PART));
    }

    @AfterEach
    void cleanup() {
        webDriver.close();
    }
}