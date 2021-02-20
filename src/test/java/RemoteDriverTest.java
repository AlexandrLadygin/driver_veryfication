import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public class RemoteDriverTest {
    Logger logger = Logger.getLogger("logger");
    //Test
    //TEST description about remote driver
    @Test
    public void remoteDriverTest(){
        URL hubUrl = null;
        try {
            hubUrl = new URL("http:localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        WebDriver driver = new RemoteWebDriver(hubUrl, DesiredCapabilities.chrome());
        logger.info("Initial driver");
        driver.get("https://awesome-shop.01sh.ru/");
        logger.info("Navigate to awesome shop");
        String title = driver.getTitle();
        logger.info("getting title = " + title);

        Assert.assertEquals(title, "Your Store",  "The titles aren't equals!");

        driver.quit();
    }
}
