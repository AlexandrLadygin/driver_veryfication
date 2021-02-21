import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.logging.Logger;

import static org.openqa.selenium.chrome.ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY;

public class PropertyDriverTest {
    Logger logger = Logger.getLogger("logger");

    @Test
    public void remoteDriverTest(){
        System.setProperty(CHROME_DRIVER_EXE_PROPERTY, "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        logger.info("Initial driver");
        driver.get("https://awesome-shop.01sh.ru/");
        logger.info("Navigate to awesome shop");
        String title = driver.getTitle();
        logger.info("getting title = " + title);

        Assert.assertEquals(title, "Your Store",  "The titles aren't equals!");

        driver.quit();
    }
}
