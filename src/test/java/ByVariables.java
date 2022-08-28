import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public class ByVariables {

    By loginBtn = RelativeLocator.with(By.cssSelector("*[type='button']"));
    By mailInpField = RelativeLocator.with(By.ByClassName.className("Textinput-Control"));
    By mailInpFld = RelativeLocator.with(By.ByName.name("login"));
    By singInBtn = RelativeLocator.with(By.ById.id("passp:sign-in"));
    By passwordFld = RelativeLocator.with(By.ByXPath.xpath("//span[contains(@class,'Textinput_')]"));
    By submitBtn = RelativeLocator.with(By.ByXPath.xpath("//*[@id='passp:sign-in']"));

    By forgotPassword = RelativeLocator.with(By.ByLinkText.linkText("https://passport.yandex.com/restoration?from=mail&origin=hostroot_homer_auth_com&retpath=https%3A%2F%2Fmail.yandex.com%2F&login=task30&process_uuid=5f9f8b67-370a-48b0-8de5-d2aa1974dc3b"));
    By forgotPass = RelativeLocator.with(By.ByPartialLinkText.partialLinkText("https://passport.yandex.com/restoration"));

    By title = RelativeLocator.with(By.ByTagName.tagName("h1"));
}
