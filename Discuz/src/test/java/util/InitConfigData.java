package util;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by shenjian on 2018/5/8.
 */
public class InitConfigData {
  public static String browserName=null;
    public WebDriver webDriver;
    public static void ReadProperties() throws IOException {
        Properties properties=new Properties();
        InputStream ips=new FileInputStream("./config.properties");
        properties.load(ips);
        browserName=properties.getProperty("browserName");
        ips.close();
        }
    static {
        try {
           InitConfigData.ReadProperties();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
