package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationStepDef {
    static WebDriver driver;
    String email = "manish." + Math.random() + "88@yahoo.in";

    @Given(": I am on registration page")
    public void i_am_on_registration_page() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://demo.nopcommerce.com/");
            driver.manage().window().maximize();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();


        }
    @When(": I enter valid First Name")
    public void i_enter_valid_first_name() {
          driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Manish");

    }
    @When(": I enter valid Last Name")
    public void i_enter_valid_last_name() {
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Dobariya");

    }
    @When(": I enter valid Email")
    public void i_enter_valid_email() {
        driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(email);
    }
    @When(": I enter valid Password")
    public void i_enter_valid_password() {
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("M5M5M5M5");
    }
    @When(": I enter valid Confirm password")
    public void i_enter_valid_confirm_password() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='ConfirmPassword']")).sendKeys("M5M5M5M5");
        Thread.sleep(3000);
    }
    @When(": I click REGISTER button")
    public void i_click_register_button() {
        driver.findElement(By.xpath("//button[@id='register-button']")).click();
    }
    @Then(": I should register successfully")
    public void i_should_register_successfully() {
        WebElement logout = driver.findElement(By.className("result"));
        System.out.println("I have registered successfully");
        Assert.assertEquals("I am registered successfully",logout.getText(),"Your registration completed");
      driver.quit();

    }

}
