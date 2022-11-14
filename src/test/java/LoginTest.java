import helper.TestUtil;
import helper.User;
import org.testng.annotations.Listeners;
import page.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static helper.Constants.EXISTING_USER;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test
    void loginTest() {
        User user = TestUtil.getUser(EXISTING_USER);
        MyAccountPage myAccountPage = authenticationPage.login(user);
        Assert.assertTrue(myAccountPage.isUserLoggedIn());
    }

}
