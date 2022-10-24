import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

@Epic("Login and logout tests")
@Feature("Login and logout tests")
@Listeners(TestListener.class)
public class LoginTest {

    private final static String URL = ("https://mail.yandex.com/");
    private static final String LOGIN = "task30";
    private static final String PASSWORD = "task30task30";
    private static final String EXPECTED_TEXT = "inbox";
    private static WebDriver webDriver;
    private StartPage startPage;
    private MailInboxPage mailInboxPage;
    private Browser browser;


    @BeforeTest
    void setup() throws IOException {
        webDriver = Browser.getInstance().getWebDriver();
        webDriver.get(URL);
        startPage = new StartPage(webDriver);
        LoginPage loginPage = startPage.clickLoginButton();
        mailInboxPage = loginPage.loginToMail(LOGIN, PASSWORD);
    }

    @Test
    @Description("Verification of log out from Yandex Mail")
    @Story("Verify user logout from Yandex Mail and navigated to Start page")
    void logoutFromYandexMailTest() {
        mailInboxPage.logout();
        Assert.assertTrue(startPage.isLogInButtonDisplayed());
    }

    @Test
    @Description("Verification of log in into Yandex Mail")
    @Story("Verify user login to Yandex Mail")
    void loginToYandexMailTest() {
        Assert.assertEquals(mailInboxPage.getInboxText(), EXPECTED_TEXT);
    }

    @Test
    @Description("Negative test for non-displayed element")
    void loginToMailAndFindUsernameTest() {
        Assert.assertTrue(mailInboxPage.isDisplayedUsername());
    }

    @AfterTest
    void cleanup() {
        webDriver.close();
    }

}

