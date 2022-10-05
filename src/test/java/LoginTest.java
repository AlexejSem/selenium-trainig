import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginTest {

    private WebDriver webDriver;
    private StartPage startPage;
    private MailInboxPage mailInboxPage;
    private final static String URL = ("https://mail.yandex.com/");
    private static final String LOGIN = "task30";
    private static final String PASSWORD = "task30task30";
    private static final String EXPECTED_TEXT = "inbox";


    @BeforeEach
    void setup() throws IOException {
        Browser browser = Browser.getInstance();
        webDriver = browser.getWebDriver();
        webDriver.get(URL);
        startPage = new StartPage(webDriver);
        startPage.getScreenShot();
        LoginPage loginPage = startPage.clickLoginButton();
        mailInboxPage = loginPage.loginToMail(LOGIN, PASSWORD);


    }

    @Test
    void logoutFromYandexMailTest() {
        mailInboxPage.logout();
        Assertions.assertTrue(startPage.isLogInButtonDisplayed());
    }

    @Test
    void loginToYandexMailTest() {
        Assertions.assertEquals(mailInboxPage.getInboxText(), EXPECTED_TEXT);
    }

    @AfterEach
    void cleanup() {
        webDriver.close();
    }
}