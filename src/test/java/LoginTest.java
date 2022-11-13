import helper.User;
import org.testng.annotations.Listeners;
import page.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test(dataProvider = "userExisting")
    void loginTest(User user) {
        MyAccountPage myAccountPage = authenticationPage.login(user);
        Assert.assertTrue(myAccountPage.isUserLoggedIn());
    }

}
