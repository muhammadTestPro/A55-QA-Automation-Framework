package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class AllSongsDefinitions {

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

    @Given("I am logged in to Koel")
    public void logInKoel(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
    }

    @When("I go to All Songs List")
    public void iGoToAllSongsList() {
        HomePage homePage = new HomePage(driver);
        homePage.chooseAllSongsList();
    }

    @When("I context click first Song")
    public void iContextClickFirstSong() {
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        allSongsPage.contextClickFirstSong();
    }

    @And("Choose play option")
    public void choosePlayOption() {
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        allSongsPage.choosePlay();
    }

    @Then("Song should be playing")
    public void songShouldBePlaying() {
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        Assert.assertTrue(allSongsPage.isSongPlaying());
    }
}
