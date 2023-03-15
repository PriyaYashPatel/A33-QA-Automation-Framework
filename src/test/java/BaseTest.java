import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.awt.*;
import java.security.Key;
import java.time.Duration;


public class BaseTest {

    public static WebDriver driver = null;
    public static String url = "https://bbb.testpro.io/";

//    Action action = (Action) new Actions (driver);


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters("baseUrl")
    public static void setUpBrowser(String baseUrl) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications","--remote-allow-origins=*","--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

//    @AfterMethod
//    public static void navigateToPage() {
//        String url = "https://bbb.testpro.io/";
//        driver.get(url);
//    }

   public static void login(String email, String password) throws InterruptedException {
       WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
       emailField.clear();
       emailField.sendKeys(email);

       WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
       passwordField.clear();
       passwordField.sendKeys(password);

       WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
       submitButton.click();
   }

    public static void createNewPlaylist(String name) throws InterruptedException {
        newPlaylistBtn();
        selectNewPlaylistOption();
        newPlaylistName(name);

    }

    public static void newPlaylistBtn() throws InterruptedException {
        WebElement newPlaylistBtn = driver.findElement(By.xpath("//section[@id='playlists'] //i[@title='Create a new playlist']"));
        newPlaylistBtn.click();
        Thread.sleep(3000);
    }

    public static void selectNewPlaylistOption() {
        WebElement selectNewPlaylistOption = driver.findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']"));
        selectNewPlaylistOption.click();
    }

    public static void newPlaylistName(String name) {
        WebElement newPlaylistName = driver.findElement(By.xpath("//input[@name='name']"));
        newPlaylistName.clear();
        newPlaylistName.sendKeys(name);
        newPlaylistName.sendKeys(Keys.ENTER);
    }

    public static void closeTheBrowser() {
        driver.quit();
    }

}
