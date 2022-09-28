import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class MultiSelectTest {

    private WebDriver driver;
    By MULTI_SELECT = By.cssSelector("select#multi-select");
    By OPTIONS = By.cssSelector("select#multi-select>option");

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    void multiSelectListTest() {
        Select multiSelect = new Select(driver.findElement(MULTI_SELECT));
        final List<WebElement> expectedSelectionOptions = multiSelect.getOptions().stream().parallel()
                .unordered().distinct().limit(3).collect(Collectors.toList());
        List<String> expSelectedOptions = expectedSelectionOptions.stream()
                .map(WebElement::getText).collect(Collectors.toList());
        expSelectedOptions.forEach(multiSelect::selectByVisibleText);
        expectedSelectionOptions.forEach(element -> new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementSelectionStateToBe(element, true)));
        List<WebElement> actualSelectedOptions = multiSelect.getAllSelectedOptions();
        Assertions.assertEquals(expectedSelectionOptions, actualSelectedOptions);
    }

    @AfterEach
    void cleanup() {
        driver.close();
    }

}
