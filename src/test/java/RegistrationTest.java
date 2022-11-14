import helper.TestUtil;
import helper.User;
import org.testng.annotations.*;
import page.AuthenticationPage;
import page.MyAccountPage;
import page.RegistrationPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;

import static helper.Constants.USA_USER;

@Epic("Login and logout tests")
@Feature("Login and logout tests")
@Listeners(TestListener.class)
public class RegistrationTest {

    private AuthenticationPage authenticationPage;

    @Test
    @Description("Verification of new user registration ability")
    @Story("Register new user")
    void registrationTest() {
        User user = TestUtil.getUser(USA_USER);
        RegistrationPage registrationPage = authenticationPage.createAccount(user.getEmail());
        MyAccountPage myAccountPage = registrationPage
                .registerNewUser(user);
        Assert.assertTrue(myAccountPage.isUserRegistered());
    }
}


