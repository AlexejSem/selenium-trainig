import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class EmployeesFilterTest {

    private WebDriver driver;
    private final static By SHOW_ENTITIES_DROPDOWN = By.cssSelector("label>select");
    private final static By TABLE = By.cssSelector("table#example>tbody");
    private final static By TABLE_ROW = By.cssSelector("tr");
    private final static By COLUMN_NAME = By.xpath("td[1]");
    private final static By COLUMN_POSITION = By.xpath("td[2]");
    private final static By COLUMN_OFFICE = By.xpath("td[3]");
    private final static By COLUMN_AGE = By.xpath("td[4]");
    private final static By COLUMN_SALARY = By.xpath("td[6]");
    private final static By NEXT_BUTTON = By.cssSelector("a.next");

    private List<Employee> employees = new ArrayList<>();

    @BeforeEach
    void setup() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.seleniumeasy.com/table-sort-search-demo.html");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @ParameterizedTest
    @CsvSource({"40, 150000"})
    void employeesFilterTest(int minAge, int maxSalary) throws InterruptedException {
        new Select(driver.findElement(SHOW_ENTITIES_DROPDOWN)).selectByValue("10");
        do {
            WebElement nextBtn = driver.findElement(NEXT_BUTTON);
            List<WebElement> rows = driver.findElement(TABLE).findElements(TABLE_ROW);
            for (WebElement row : rows) {
                int age = Integer.parseInt(row.findElement(COLUMN_AGE).getText());
                int salary = Integer.parseInt(row.findElement(COLUMN_SALARY).getAttribute("data-order"));
                if (age > minAge && salary <= maxSalary) {
                    String name = row.findElement(COLUMN_NAME).getText();
                    String position = row.findElement(COLUMN_POSITION).getText();
                    String office = row.findElement(COLUMN_OFFICE).getText();
                    employees.add(new Employee(name, position, office));
                }
            }
            nextBtn.click();
        } while (!driver.findElement(NEXT_BUTTON).getAttribute("class").contains("disabled"));
        Assertions.assertFalse(employees.isEmpty());
    }

    @AfterEach
    void cleanup() {
        driver.close();
    }
}
