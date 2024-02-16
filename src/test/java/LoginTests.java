import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {
        //navigateToPage();
        //Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        //Steps 1: Open Browser and navigate to Koel app.
        //navigateToPage();
        //Step 2: Enter email
        provideEmail("demo12@class.com");
        //Step 3: Enter Password
        providePassword("te$t$tudent");
        //Step 4: Click on Login button
        loginToKoel();
        //Assertion (expected vs actual)
        //WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Explicit wait
        //WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        WebElement avatarIcon = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    //Login with Valid email Test using the Page Object Model
    @Test
    public void loginValidEmailValidPasswordTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("demo@class.com");
        Thread.sleep(2000);
        loginPage.providePassword("te$t$tudent");
        Thread.sleep(2000);
        loginPage.clickSubmit();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginInValidEmailValidPasswordTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("demos3@class.com");
        Thread.sleep(2000);
        loginPage.providePassword("te$t$tudent");
        Thread.sleep(2000);
        loginPage.clickSubmit();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginEmptyEmailPasswordTest() throws InterruptedException {

            LoginPage loginPage = new LoginPage(getDriver());
            HomePage homePage = new HomePage(getDriver());

            loginPage.provideEmail("");
            Thread.sleep(2000);
            loginPage.providePassword("");
            Thread.sleep(2000);
            loginPage.clickSubmit();
            Thread.sleep(2000);
            Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    @Test
    public void loginEmptyEmailvalidPasswordTest() throws InterruptedException {

            LoginPage loginPage = new LoginPage(getDriver());
            HomePage homePage = new HomePage(getDriver());

            loginPage.provideEmail("");
            Thread.sleep(2000);
            loginPage.providePassword("te$t$tudent");
            Thread.sleep(2000);
            loginPage.clickSubmit();
            Thread.sleep(2000);
            Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    @Test(dataProvider = "invalidLoginData", dataProviderClass = TestData.class)
    public void loginWithNegativeData(String email, String password){
        //navigateToPage();
        //Step 2: Enter email
        provideEmail(email);
        //Step 3: Enter Password
        providePassword(password);
        //Step 4: Click on Login button
        loginToKoel();
        //Assertion (expected vs actual)
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }




/*
    @Test
    public void loginInvalidEmailValidPassword(){
        //navigateToPage();
        //Step 2: Enter email
        provideEmail("invalid@class.com");
        //Step 3: Enter Password
        providePassword("te$t$tudent");
        //Step 4: Click on Login button
        loginToKoel();
        //Assertion (expected vs actual)
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
        //Quit the browser
        //driver.quit();
    }

    @Test
    public void loginwithNoCredentials(){
        provideEmail("invalid@class.com");
        //Step 3: Enter Password
        providePassword("te$t$tudent");
        //Step 4: Click on Login button
        loginToKoel();
    }

    @Test
    public void loginValidEmailEmptyPassword(){
        //Step 2: Enter email
        provideEmail("demo@class.com");
        //Step 3: Enter Password
        providePassword("");
        //Step 4: Click on Login button
        loginToKoel();
        //Assertion (expected vs actual)
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
        //Quit the browser
        driver.quit();
    }*/


}
