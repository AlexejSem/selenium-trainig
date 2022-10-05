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

    private WebDriver webDriver;
    private static By LOGIN_BUTTON = By.cssSelector("button[type]");
    private static String SCREENSHOT_FILE_PATH = "src/test/recorces/screenshot.png";

    public StartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void getScreenShot() throws IOException {
        File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(SCREENSHOT_FILE_PATH));
    }

    public LoginPage clickLoginButton() {
        webDriver.findElement(LOGIN_BUTTON).click();
        return new LoginPage(webDriver);
    }

    public boolean isLogInButtonDisplayed() {
        new WebDriverWait(this.webDriver, Duration.ofSeconds(7)).until(ExpectedConditions.presenceOfElementLocated(LOGIN_BUTTON));
        return webDriver.findElement(LOGIN_BUTTON).isDisplayed();
    }
}