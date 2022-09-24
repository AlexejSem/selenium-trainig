import org.junit.jupiter.api.AfterEach;
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


public class ObjectSelectionTest {

    private WebDriver driver;

    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.seleniumeasy.com/table-sort-search-demo.html");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @ParameterizedTest
    @CsvSource({"40, 150000"})
    List<ObjectsForSelection> objectSelectionTest(int x, int y) {
        Select showEntitiesDropDown = new Select(driver.findElement(By.cssSelector("label>select")));
        showEntitiesDropDown.selectByValue("10");

        int numberOfPages = Integer.parseInt(driver.findElement(By.cssSelector("span>a:nth-child(4)")).getText());
        WebElement table = driver.findElement(By.cssSelector("table#example>tbody"));
        List<List<String>> allEmployees = new ArrayList<>();
        List<ObjectsForSelection> employees = new ArrayList<>();

        int currentPage = 1;
        while (currentPage <= numberOfPages) {
            WebElement nextButton = driver.findElement(By.cssSelector("a.next"));
            List<WebElement> rows = table.findElements(By.tagName("tr"));
            for (WebElement row : rows) {
                List<String> employee = new ArrayList<>();
                List<WebElement> cols = row.findElements(By.tagName("td"));
                for (WebElement col : cols) {
                    employee.add(col.getText());
                }
                allEmployees.add(employee);
                System.out.println();
            }
            nextButton.click();
            currentPage++;
        }
        for (List<String> employee : allEmployees) {
            String name = employee.get(0);
            String position = employee.get(1);
            String office = employee.get(2);
            int age = Integer.parseInt(employee.get(3));
            String wage = employee.get(5).replaceAll("[^\\d.]","");
            int salary = Integer.parseInt(wage);
            if( age > x && salary <= y){
                employees.add(new ObjectsForSelection(name, position, office, age, salary));
            }
        }
        return employees;
    }

    @AfterEach
    void cleanup(){
        driver.close();
    }
}
