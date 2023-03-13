import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public static void playSongTest() throws InterruptedException {
        login("testguest@testpro.io","te$t$tudent");
        playSongBtn();

        Assert.assertTrue(isDisplayedPlayingSong());
    }

    public static void playSongBtn() throws InterruptedException {
        WebElement buttonPlaySongNxt = driver.findElement(By.cssSelector("[data-testid='play-nxt-btn']"));
        WebElement buttonPlaySong = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        Thread.sleep(3000);
        buttonPlaySongNxt.click();
        buttonPlaySong.click();
    }

    public static boolean isDisplayedPlayingSong() {
        WebElement songIsPlaying = driver.findElement(By.cssSelector("[data-testid='sound-bar-play']"));
        return songIsPlaying.isDisplayed();
    }

}
