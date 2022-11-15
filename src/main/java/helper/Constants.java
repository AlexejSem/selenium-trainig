package helper;

import org.openqa.selenium.By;

public class Constants {
    public final static String URL = ("http://automationpractice.com/index.php");
    public static final String GRID_URL = "https://localhost/4444/wd/hub";
    public static final String SAUCE_URL = "https://oauth-aleksejsemaskevic0-d7bca:6277fef9-d159-429a-aacc-a45dd447144a"
            + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
    public final static By CATEGORY_PANEL = By.xpath("//li/a[@title='Women']");
    public final static String WOMEN_CATEGORY = "Women";
    public final static String WISHLIST_NAME = "Created by autotest wishlist";
    public final static int EXPECTED_QUANTITY_OF_PRODUCTS = 1;
    public static final int USA_USER = 0;
    public static final int CANADIAN_USER = 1;
    public static final int EXISTING_USER = 3;

}
