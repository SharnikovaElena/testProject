package test.java;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginTest extends BaseTest {

    @Test(description = "User authorization on the site. Using correct data in the 'Login' and 'Password' fields")
    public void login() {
        log.info("Run login test");
        log.info("Opening a page login for entering email and password");
        open("/login");
        log.debug("Entering correct data in the 'email' field");
        $("#inputEmail").sendKeys(email);
        log.debug("Entering correct data in the 'password' field and pressing the button 'Login");
        $(By.xpath("//input[@id='inputPassword']")).setValue(password).submit(); // $("#btnLogin").click();
        log.debug("Verifying that authorization was successful");
        $(CREATE_NEW_PROJECT_BUTTON).shouldBe(Condition.visible);
        log.info("Login test completed");
    }
}
