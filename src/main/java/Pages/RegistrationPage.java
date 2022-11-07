package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    private WebDriver driver;
    private static final By FIRSTNAME_INPUT = By.cssSelector("input#customer_firstname");
    private static final By LASTNAME_INPUT = By.cssSelector("input#customer_lastname");
    private static final By PASSWORD_INPUT = By.cssSelector("input#passwd");
    private static final By ADDRESS_INPUT = By.cssSelector("input#address1");
    private static final By CITY_INPUT = By.cssSelector("input#city");
    private static final By STATE_SELECT = By.cssSelector("select#id_state");
    private static final By POST_CODE_INPUT = By.cssSelector("input#postcode");
    private static final By MOBILE_PHONE_INPUT = By.cssSelector("input#phone_mobile");
    private static final By SUBMIT_BUTTON = By.id("submitAccount");


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public MyAccountPage registerNewUser(String firstName, String lastName, String password, String address,
                                         String city, int state, String postCode, String mobilePhone) {
        driver.findElement(FIRSTNAME_INPUT).sendKeys(firstName);
        driver.findElement(LASTNAME_INPUT).sendKeys(lastName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(ADDRESS_INPUT).sendKeys(address);
        driver.findElement(CITY_INPUT).sendKeys(city);
        Select statesDropDown = new Select(driver.findElement(STATE_SELECT));
        statesDropDown.selectByValue(String.valueOf(state));
        driver.findElement(POST_CODE_INPUT).sendKeys(postCode);
        driver.findElement(MOBILE_PHONE_INPUT).sendKeys(mobilePhone);
        driver.findElement(SUBMIT_BUTTON).click();
        return new MyAccountPage(driver);
    }

}
