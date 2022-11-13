import browser.Driver;
import helper.Constants;
import page.AuthenticationPage;
import page.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    private WebDriver driver;
    private HomePage homePage;
    AuthenticationPage authenticationPage;

    @BeforeTest
    void setup() {
        driver = Driver.getInstance().getDriver();
        driver.get(Constants.URL);
        homePage = new HomePage();
        authenticationPage = homePage.clickSignInButton();
    }

    @AfterTest
    void cleanup() {
        driver.close();
    }

}
