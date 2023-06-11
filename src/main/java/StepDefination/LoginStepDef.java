package StepDefination;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class LoginStepDef {
    static WebDriver driver;

    @Given("User is on login page")
    public void user_is_on_login_page() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://example.testproject.io/web/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @When("User Enter userName {string}")
    public void userEnterValidFullName(String fullName) {
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(fullName);
    }

    @When("User Enter pass {string}")
    public void userEnterValidPassword(String password) {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @Then("user should see a validation message {string}")
    public void userShouldSeeValidationMessage(String expectedMessage) throws InterruptedException {
        Thread.sleep(3000);
        String welcomeMessage = driver.findElement(By.id("greetings")).getText();
        System.out.println(welcomeMessage);
        assertEquals(expectedMessage, welcomeMessage);
        driver.quit();
    }


    @When("User click on Login button")
    public void userClickLoginButton() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='login']")).click();
    }

    @Then("user should see an invalidation message {string}")
    public void userShouldSeeInvalidationMessage(String message) throws InterruptedException {
        Thread.sleep(3000);
        String invalidMessage = driver.findElement(By.xpath("//div[normalize-space()='Password is invalid']")).getText();
        assertEquals(message, invalidMessage);
        driver.quit();
    }

    @Then("user should see an error message {string}")
    public void userShouldSeeAnErrorMessage(String message) {
        String invalidMessage = driver.findElement(By.xpath("//div[contains(text(),'Please provide your full name')]")).getText();
        assertEquals(message,invalidMessage);
        driver.quit();
    }

}
