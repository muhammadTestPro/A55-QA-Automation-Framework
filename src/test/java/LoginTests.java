import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        provideEmail("demo@class.com");
        //Step 3: Enter Password
        providePassword("te$t$tudent");
        //Step 4: Click on Login button
        loginToKoel();
        //Assertion (expected vs actual)
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
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
