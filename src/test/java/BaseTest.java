package test.java;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertyReader;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    protected static String email, password;
    protected static final By EMAIL_INPUT = By.id("inputEmail");
    protected static final By PASSWORD_INPUT = By.xpath("//input[@id='inputPassword']");
    protected static final By CREATE_NEW_PROJECT_BUTTON = By.id("createButton");
    protected static final By CREATE_SUITE_BUTTON = By.id("create-suite-button");

    @BeforeMethod
    public void setup() {
        Configuration.headless = true;
//        Configuration.baseUrl = "https://app.qase.io";
        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url"));
        email = System.getenv().getOrDefault("QASE_EMAIL", PropertyReader.getProperty("qase.email"));
        password = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password"));
        Configuration.browser = "chrome";
        Configuration.timeout = 8000;
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        getWebDriver().quit();

//        WebDriver driver = new ChromeDriver();
//        setWebDriver(driver);
    }
}

