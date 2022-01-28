package test.java;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class CreateSuiteTest extends BaseTest {

    private static final By PROJECT_NAME = By.xpath("//a[text()='Demo Project']");
    private static final By MODAL_HEADER = By.xpath("//h2[text()='Create suite']");
    private static final By SUITE_NAME_INPUT = By.id("name");
    private static final By DESCRIPTION_INPUT = By.xpath("//div[@id='descriptionGroup']//div[@class='ProseMirror toastui-editor-contents']");
    private static final By PRECONDITIONS = By.xpath("//div[@id='preconditionsGroup']//div[@class='ProseMirror toastui-editor-contents']");
    private static final By SAVE_SUITE_BUTTON = By.id("save-suite-button");
    private static final By NEW_SUITE_HEADER = By.xpath("//div[contains(@id,'tree-suite')]//a[text()='Little Hangleton']");

    static Faker faker = new Faker();

    @Test(description = "Verifying the creation of a new test suite in the Demo Project")
    public void createSuite() {
        log.info("Run CreateSuiteTest test");
        open("/login");
        $(EMAIL_INPUT).sendKeys(email);
        $(PASSWORD_INPUT).setValue(password).submit();
        log.info("Click the 'Demo Project' title");
        $(PROJECT_NAME).click();
        log.debug("Checking that we have navigated to the 'Demo Project' page");
        $(CREATE_SUITE_BUTTON).shouldBe(Condition.visible);
        log.info("Click the '+SUITE' button");
        $(CREATE_SUITE_BUTTON).click();
        log.debug("Checking that the modal window 'Create suite' has opened");
        $(MODAL_HEADER).shouldHave(Condition.exactText("Create suite"));
        log.info("Filling in the fields of the modal window 'Create suite'");
        $(SUITE_NAME_INPUT).sendKeys(faker.harryPotter().location());
        $(DESCRIPTION_INPUT).sendKeys(faker.harryPotter().book());
        $(PRECONDITIONS).sendKeys(faker.harryPotter().house());
        log.info("Clicking on the 'Create' button");
        $(SAVE_SUITE_BUTTON).click();
        log.debug("Checking that the new suite has been created");
        $(NEW_SUITE_HEADER).shouldBe(Condition.visible);
        log.info("CreateSuiteTest completed");
    }
}
