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

@Epic("Login and logout tests")
@Feature("Login and logout tests")
@Listeners(TestListener.class)
public class NewUserRegistrationTest {

    private AuthenticationPage authenticationPage;

    @Test(dataProvider = "userUSA")
    @Description("Verification of new user registration ability")
    @Story("Register new user")
    void registerNewUserTest(User user) {
        RegistrationPage registrationPage = authenticationPage.createAccount(user.getEmail());
        MyAccountPage myAccountPage = registrationPage
                .registerNewUser(user);
        Assert.assertTrue(myAccountPage.isUserRegistered());
    }
}


