import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllSongsTest extends BaseTest{

    @Test
    public void playSongWithContextClick() throws InterruptedException {
        //Login
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        loginToKoel();
        //Thread.sleep(2000);
        //chooseAllSongsList();
        chooseAllSongsList();
        //Thread.sleep(2000);
        //contextClickFirstSong();
        contextClickFirstSong();
        //Thread.sleep(2000);
        //choosePlay();
        choosePlay();
        //Thread.sleep(2000);
        //Assertions
        Assert.assertTrue(isSongPlaying());
    }

    public boolean isSongPlaying(){
        WebElement soundBarVisualizer = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[data-testid= 'sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();
    }

    public void choosePlay() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
    }

    public void contextClickFirstSong() {
        WebElement firstSongElement = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongElement).perform();
    }



}
