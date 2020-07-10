import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class AlfaBankSite {
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
    public void searchUrl() throws InterruptedException, IOException {

        driver.get("https://www.yandex.ru/");
        String actualTitle = driver.getTitle();
        GetTimeFileName.timeFileName();

        driver.findElement(By.id("text")).click();
        driver.findElement(By.id("text")).clear();
        driver.findElement(By.id("text")).sendKeys("Альфа Банк");
        driver.findElement(By.id("text")).sendKeys(Keys.ENTER);
        //Thread.sleep(3000);

        driver.findElement(By.cssSelector("#search-result > li:nth-child(5) > div > h2 > a > div.favicon.favicon_page_0 > div")).click();
        ArrayList<String> tabs_windows = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs_windows.get(1));
        Thread.sleep(2000);
        JavascriptExecutor Scrool = (JavascriptExecutor) driver;
        Scrool.executeScript("window.scrollBy(0,20000)", "");
        Thread.sleep(2000);
        driver.findElement(By.linkText("Вакансии")).click();

        String aboutUs = driver.findElement(By.cssSelector("#content > div:nth-child(2) > div > h3")).getText() + System.lineSeparator() + driver.findElement(By.cssSelector("#content > div:nth-child(2) > div > div.top-32")).getText();

        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String broweserName = cap.getBrowserName().toLowerCase();
        String idName = GetTimeFileName.timeFileName() + " " + broweserName + " " + actualTitle;

        CreateFileTest.creatFileTest(idName, aboutUs);

    }

    @After
    public void closeWeb() {
        driver.quit();
    }
}

