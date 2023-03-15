import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework19 extends BaseTest {
    @Test
    public static void deleteEmptyPlaylist() throws InterruptedException {
        login("testguest@testpro.io","te$t$tudent");
        createNewPlaylist("DelPlaylist");
        openNewPlaylist();
        delNewPlaylist();

        WebElement delPlaylistMsg = getDelPlaylistNotification();
        Assert.assertTrue(delPlaylistMsg.isDisplayed());
    }

    public static void openNewPlaylist() {
        WebElement emptyPlaylist = driver.findElement(By.xpath("//section[@id='playlists'] //*[contains(text(),'DelPlaylist')]"));
        emptyPlaylist.click();
    }

    public static void delNewPlaylist() {
        WebElement delPlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        delPlaylist.click();
    }

    public static WebElement getDelPlaylistNotification() {
        return driver.findElement(By.cssSelector("div.success.show"));
    }
}
