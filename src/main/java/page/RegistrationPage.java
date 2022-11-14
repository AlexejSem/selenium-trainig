package page;

import helper.User;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {
    private static final By FIRSTNAME_INPUT = By.cssSelector("input#customer_firstname");
    private static final By LASTNAME_INPUT = By.cssSelector("input#customer_lastname");
    private static final By PASSWORD_INPUT = By.cssSelector("input#passwd");
    private static final By ADDRESS_INPUT = By.cssSelector("input#address1");
    private static final By CITY_INPUT = By.cssSelector("input#city");
    private static final By STATE_SELECT = By.cssSelector("select#id_state");
    private static final By POST_CODE_INPUT = By.cssSelector("input#postcode");
    private static final By MOBILE_PHONE_INPUT = By.cssSelector("input#phone_mobile");
    private static final By SUBMIT_BUTTON = By.id("submitAccount");

    public RegistrationPage() {
        super();
    }

    public MyAccountPage registerNewUser(User user) {
        driver.findElement(FIRSTNAME_INPUT).sendKeys(user.getFirstname());
        driver.findElement(LASTNAME_INPUT).sendKeys(user.getLastname());
        driver.findElement(PASSWORD_INPUT).sendKeys(user.getPassword());
        driver.findElement(ADDRESS_INPUT).sendKeys(user.getAddress());
        driver.findElement(CITY_INPUT).sendKeys(user.getCity());
        Select statesDropDown = new Select(driver.findElement(STATE_SELECT));
        statesDropDown.selectByVisibleText(user.getState());
        driver.findElement(POST_CODE_INPUT).sendKeys(user.getPostcode());
        driver.findElement(MOBILE_PHONE_INPUT).sendKeys(user.getPhoneNumber());
        driver.findElement(SUBMIT_BUTTON).click();
        return new MyAccountPage();
    }

}
