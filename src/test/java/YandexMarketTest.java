import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class YandexMarketTest {
    WebDriver driver;
    private static final int DELAY = 50;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(DELAY, TimeUnit.SECONDS);
    }

    @Test
    public void comparePhoneName() throws InterruptedException {
        driver.get("https://yandex.ru/");
        driver.findElement(By.linkText("Маркет")).click();
        ArrayList<String> tabs_windows = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs_windows.get(1));
        driver.findElement(By.xpath("//div/div/div/div[2]/div/div/div[3]/div/a/span")).click(); //electronics
        driver.findElement(By.cssSelector("body > div._111XIPXNiH.main > div.n-scroll-through.i-bem > div:nth-child(6) > div > div > div > div.sxrttPxJA0.a6VijDBKnU > div > div > div > div > div > div > div:nth-child(1) > div._3VMnEHDoVX > ul > li:nth-child(1) > div > a")).click(); //phones
        driver.findElement(By.cssSelector("#search-prepack > div > div:nth-child(3) > div > div > div._178jz2CyDL > div:nth-child(3) > div > div > fieldset > ul > li:nth-child(9) > div > a > label > div")).click(); //samsung checkbox
        driver.findElement(By.id("glpricefrom")).click(); //line for enter_price
        driver.findElement(By.id("glpricefrom")).sendKeys("40000"); //input price filter
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("body > div._111XIPXNiH.main > div:nth-child(7) > div.layout.layout_type_search.i-bem > div > div:nth-child(1) > div > div > div > article:nth-child(1) > div.d0N9PZYfeg._2TsfEK2hPa > div._1NyIdwOZ6-")).getText().contains("SAMSUNG"));
        String discribe = driver.findElement(By.cssSelector("body > div._111XIPXNiH.main > div:nth-child(7) > div.layout.layout_type_search.i-bem > div > div:nth-child(1) > div > div > div > article:nth-child(1) > div.d0N9PZYfeg._2TsfEK2hPa > h3 > a > span")).getText(); //take a name
        driver.findElement(By.cssSelector("body > div._111XIPXNiH.main > div:nth-child(7) > div.layout.layout_type_search.i-bem > div > div:nth-child(1) > div > div > div > article:nth-child(1) > div.d0N9PZYfeg._2TsfEK2hPa > h3 > a > span")).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(2));
        String namesam = driver.findElement(By.cssSelector("body > div._111XIPXNiH.main > div:nth-child(12) > div > div._1_OV2Lbe5i > div > div > div:nth-child(2)")).getText();
        Assert.assertEquals(discribe, namesam);
    }


    @Test
    public void compareHeadphoneName() throws InterruptedException {
        driver.get("https://yandex.ru/");
        driver.findElement(By.linkText("Маркет")).click();
        ArrayList<String> tabs_windows = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs_windows.get(1));
        driver.findElement(By.xpath("//div/div/div/div[2]/div/div/div[3]/div/a/span")).click(); //electronics
        driver.findElement(By.cssSelector("body > div._111XIPXNiH.main > div.n-scroll-through.i-bem > div:nth-child(6) > div > div > div > div.sxrttPxJA0.a6VijDBKnU > div > div > div > div > div > div > div:nth-child(2) > div._3VMnEHDoVX > ul > li:nth-child(1) > div > a")).click();
        driver.findElement(By.cssSelector("#search-prepack > div > div:nth-child(3) > div > div > div._178jz2CyDL > div:nth-child(2) > div > div > fieldset > ul > li:nth-child(2) > div > a > label > div")).click();
        driver.findElement(By.cssSelector("#glpricefrom")).sendKeys("17000");
        driver.findElement(By.cssSelector("#glpriceto")).sendKeys("25000");
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("body > div._111XIPXNiH.main > div:nth-child(6) > div.layout.layout_type_search.i-bem > div > div:nth-child(1) > div > div > div > article:nth-child(1) > div._1OAvzJPfIW > div._1B9w_GzQuM > h3 > a > span")).getText().contains("Beats"));
        String beatsName = driver.findElement(By.cssSelector("body > div._111XIPXNiH.main > div:nth-child(6) > div.layout.layout_type_search.i-bem > div > div:nth-child(1) > div > div > div > article:nth-child(1) > div._1OAvzJPfIW > div._1B9w_GzQuM > h3 > a > span")).getText();
        driver.findElement(By.cssSelector("body > div._111XIPXNiH.main > div:nth-child(6) > div.layout.layout_type_search.i-bem > div > div:nth-child(1) > div > div > div > article:nth-child(1) > div._1OAvzJPfIW > div._1B9w_GzQuM > h3 > a > span")).click();
        ArrayList<String> tabs_windows1 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs_windows1.get(2));
        String beatsDiscName = driver.findElement(By.cssSelector("body > div._111XIPXNiH.main > div:nth-child(12) > div > div._1_OV2Lbe5i > div > div > div:nth-child(2) > h1")).getText();

        Assert.assertEquals(beatsDiscName, beatsName);
    }

    @After
    public void closeWeb() {
        driver.quit();
    }
}