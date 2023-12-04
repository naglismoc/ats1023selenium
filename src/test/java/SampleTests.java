import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class SampleTests {
        static WebDriver driver;

    @Test
    public void positiveSearch(){
        driver.findElement(By.id("searchKeyword")).sendKeys("sekatorius");
        driver.findElement(By.id("searchButton")).click();
    }

    @Test
    public void noKeywordSearch(){
        driver.findElement(By.id("searchKeyword")).sendKeys("");
        driver.findElement(By.id("searchButton")).click();
    }
    @Test
    public void lithuanianSymbolsTest(){
        driver.findElement(By.id("searchKeyword")).sendKeys("ačiū kortelė");
        driver.findElement(By.id("searchButton")).click();
    }
    @Test
    public void specialCharactersTest(){
        driver.findElement(By.id("searchKeyword")).sendKeys("$#^&*^%^%^^$#&#");
        driver.findElement(By.id("searchButton")).click();
    }

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        acceptCookies();
    }
    public void acceptCookies(){
        driver.get("https://www.skelbiu.lt");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

    }

    @BeforeMethod
    public void getWebsite(){
        driver.get("https://www.skelbiu.lt");
    }
    @AfterMethod
    public void wait3S(){
        try {Thread.sleep(3000);} catch (InterruptedException e) {}
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
