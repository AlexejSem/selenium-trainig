import helper.TestUtil;
import org.testng.annotations.DataProvider;


import static helper.Constants.*;

public class UserDataProvider {

    @DataProvider(name = "userUSA")
    public Object[][] getUserUSA() {
        return new Object[][]{{TestUtil.getUser(USA_USER)}};
    }

    @DataProvider(name = "userCanada")
    public Object[][] getUserCanada() {
        return new Object[][]{{TestUtil.getUser(CANADIAN_USER)}};
    }

    @DataProvider(name = "userExisting")
    public Object[][] getExistingUser() {
        return new Object[][]{{TestUtil.getUser(EXISTING_USER)}};
    }
}
