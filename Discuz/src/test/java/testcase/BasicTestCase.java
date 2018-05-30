package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.LogConfiguration;
import util.SeleniumUtil;

import java.util.logging.Logger;

/**
 * Created by shenjian on 2018/5/7.
 */
public class BasicTestCase {
    SeleniumUtil seleniumUtil=null;
   public  WebDriver driver=null;

    @BeforeMethod
    public void setUp(){
        LogConfiguration.initLog();
        seleniumUtil = new SeleniumUtil();
        driver = seleniumUtil.getDriver();
        seleniumUtil.url("http://127.0.0.1:8086/upload/forum.php");

    }
    @AfterMethod
    public void tearDown(){
         driver.quit();
    }
}
