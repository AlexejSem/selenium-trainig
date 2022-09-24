import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MultiSelectTest {

    private WebDriver driver;

    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    void multiSelectListTest(){
        List<WebElement> options = driver.findElements(By.cssSelector("select#multi-select>option"));
        Stream<WebElement> optionStream = options.stream().parallel().unordered();
        List<WebElement> optionsForSelect = optionStream.distinct().limit(3).collect(Collectors.toList());
        optionsForSelect.forEach(WebElement::click);
        optionsForSelect.forEach(element -> new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementSelectionStateToBe(element, true)));
        Assertions.assertAll( () -> optionsForSelect.forEach(WebElement::isSelected));
    }

    @AfterEach
    void cleanup(){
        driver.close();
    }

}
