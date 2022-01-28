package test.java;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class CreateNewProjectTest extends BaseTest {

    static Faker faker = new Faker();

    private static final By PROJECT_NAME_INPUT = By.id("inputTitle");
    private static final By PROJECT_CODE_INPUT = By.id("inputCode");
    private static final By DESCRIPTION_INPUT = By.id("inputDescription");
    private static final By PROJECT_ACCESS_TYPE = By.xpath("//*[@class='form-check-input project-access-type']");
    private static final By MEMBERS_ACCESS = By.xpath("//*[@class='form-check-input project-access']");
        private static final By CREATE_PROJECT_BUTTON = By.xpath("//*[@class='btn btn-primary']");

    @Test(description = "Checking the creation of a new project")
    public static void createNewProject() {
        log.info("Run createNewProject test");
        open("/login");
        $(EMAIL_INPUT).sendKeys(email);
        $(PASSWORD_INPUT).setValue(password).submit();
        log.info("Click the 'Create new project' button");
        $(CREATE_NEW_PROJECT_BUTTON).click();
        log.info("Fill in all fields to create a new project");
        $(PROJECT_NAME_INPUT).sendKeys(faker.harryPotter().book());
        $(PROJECT_CODE_INPUT).setValue(faker.harryPotter().house());
        $(DESCRIPTION_INPUT).setValue(faker.friends().character());
        $(PROJECT_ACCESS_TYPE).selectRadio("private");
        $(MEMBERS_ACCESS).selectRadio("group");
        log.info("Click on the 'Create project' button");
        $(CREATE_PROJECT_BUTTON).submit();
        log.debug("Checking that the project has been created");
        $(CREATE_SUITE_BUTTON).shouldBe(Condition.visible);
    }
}

