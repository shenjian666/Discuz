
import org.openqa.selenium.WebDriver;
import util.SeleniumUtil;

/**
 * Created by shenjian on 2018/5/8.
 */
public class test {
    public static void main(String[] args) {
      SeleniumUtil  seleniumUtil = new SeleniumUtil();
       WebDriver driver = seleniumUtil.getDriver();
        driver.get("http://www.baidu.com");
    }
}
