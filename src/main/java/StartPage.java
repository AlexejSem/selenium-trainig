import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class StartPage {

    private static By LOGIN_BUTTON = By.cssSelector("button[type]");
    private static String SCREENSHOT_FILE_PATH = "src/test/screenshot/screenshot.png";
    private WebDriver webDriver;

    public StartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void getScreenShot() throws IOException {
        File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(SCREENSHOT_FILE_PATH));
    }

    @Step("Click Login button to get to Login Page")
    public LoginPage clickLoginButton() {
        webDriver.findElement(LOGIN_BUTTON).click();
        return new LoginPage(webDriver);
    }

    @Step("Verify Login button is displayed")
    public boolean isLogInButtonDisplayed() {
        new WebDriverWait(this.webDriver, Duration.ofSeconds(7)).
                until(ExpectedConditions.presenceOfElementLocated(LOGIN_BUTTON));
        return webDriver.findElement(LOGIN_BUTTON).isDisplayed();
    }
}