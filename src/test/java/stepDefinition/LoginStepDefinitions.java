package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;

import java.time.Duration;

public class LoginStepDefinitions {

    WebDriver driver;

    WebDriverWait wait;

    //@Given("I open Browser")
    @Before
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://qa.koel.app/");
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }


   /* @And("I open Login Page")
    public void iOpenLoginPage() {
        driver.get("https://qa.koel.app/");
    }*/

    @When("I enter email {string}")
    public void iEnterEmail(String email) throws InterruptedException {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(email);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
        //Thread.sleep(2000);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) throws InterruptedException {
        /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys(password);
        Thread.sleep(2000);*/
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }

    @And("I click on login button")
    public void iClickOnLoginButton() throws InterruptedException {
       /* wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']"))).click();
        Thread.sleep(2000);*/
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmit();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() throws InterruptedException {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
        Thread.sleep(2000);
    }
}
