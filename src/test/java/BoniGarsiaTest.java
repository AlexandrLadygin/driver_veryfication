import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class BoniGarsiaTest {
    Logger logger = Logger.getLogger("logger");
    //very hard to deploy using jenkins
    //info for stashing
    //800

    //new new new comment
    @Test
    public void webDriverManagerTest(){
        WebDriverManager.chromedriver().setup();
        logger.info("Setup chrome driver");
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
