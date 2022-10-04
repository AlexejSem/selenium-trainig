import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;

public class LoginTest {

    private WebDriver webDriver;
    private StartPage startPage;
    private final static String URL = ("https://mail.yandex.com/");
    private static final String LOGIN_AND_PASSWORD = "task30, task30task30";
    private static final String EXPECTED_TEXT = "inbox";


    @BeforeEach
    void setup() {
        Browser browser = Browser.getInstance();
        webDriver = browser.getWebDriver();
        webDriver.get(URL);
        startPage = new StartPage(webDriver);
    }

    @ParameterizedTest
    @CsvSource(LOGIN_AND_PASSWORD)
    void logoutFromYandexMailTest(String login, String password) {
        LoginPage loginPage = startPage.clickLoginButton();
        MailInboxPage mailInboxPage = loginPage.loginToMail(login, password);
        mailInboxPage.logout();
        Assertions.assertTrue(startPage.isLogInButtonDisplayed());
    }

    @ParameterizedTest
    @CsvSource(LOGIN_AND_PASSWORD)
    void loginToYandexMailTest(String login, String password) {
        LoginPage loginPage = startPage.clickLoginButton();
        MailInboxPage mailInboxPage = loginPage.loginToMail(login, password);
        Assertions.assertEquals(mailInboxPage.getInboxText(), EXPECTED_TEXT);
    }

    @AfterEach
    void cleanup() {
        webDriver.close();
    }
}