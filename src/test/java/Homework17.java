import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public static void addSongToPlaylist() throws InterruptedException {

        String newSongAddedNotificationText = "Added 1 song into";

        navigateToPage();
        provideEmail("testguest@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        searchSong("Pluto");
        clickViewAllButton();
        selectFirstSongResult();
        clickAddToButton();
        choosePlaylist();
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));

    }

    public static void searchSong (String songTitleKeyword) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.sendKeys(songTitleKeyword);
        Thread.sleep(3000);
    }

    public static void clickViewAllButton () throws InterruptedException {
        WebElement viewAllSearchResult = driver.findElement(By.cssSelector("div.results section.songs h1 button")); //xpath - //button[@data-test='view-all-songs-btn']
        viewAllSearchResult.click();
        Thread.sleep(3000);
    }

    public static void selectFirstSongResult() throws InterruptedException {
        WebElement firstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        firstSongResult.click();
        Thread.sleep(3000);
    }

    public static void clickAddToButton() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.cssSelector("button.btn-add-to")); //xpath - //button[@data-test='add-to-btn']
        addToButton.click();
        Thread.sleep(3000);
    }

    public static void choosePlaylist () throws InterruptedException {
        WebElement playlistElement = driver.findElement(By.xpath("//section[@id='songResultsWrapper'] //li[text()[contains(.,'Test123')]]"));
        playlistElement.click();
        Thread.sleep(3000);
    }
    public static String getNotificationText() {
        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        return notificationElement.getText();
    }

}
