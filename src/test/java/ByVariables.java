import org.openqa.selenium.By;

public class ByVariables {

    By loginBtn = By.cssSelector("*[type='button']");
    By mailInpField = By.ByClassName.className("Textinput-Control");
    By mailInpFld = By.ByName.name("login");
    By singInBtn = By.ById.id("passp:sign-in");
    By passwordFld = By.ByXPath.xpath("//span[contains(@class,'Textinput_')]");
    By submitBtn = By.ByXPath.xpath("//*[@id='passp:sign-in']");

    By forgotPassword = By.ByLinkText.linkText("https://passport.yandex.com/restoration?from=mail&origin=hostroot_homer_auth_com&retpath=https%3A%2F%2Fmail.yandex.com%2F&login=task30&process_uuid=5f9f8b67-370a-48b0-8de5-d2aa1974dc3b");
    By forgotPass = By.ByPartialLinkText.partialLinkText("https://passport.yandex.com/restoration");

    By title = By.ByTagName.tagName("h1");
}
