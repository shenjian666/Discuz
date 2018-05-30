package util;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Set;


/**
 * Created by shenjian on 2018/5/7.
 */
public class SeleniumUtil {
    private static Logger logger= Logger.getLogger(SeleniumUtil.class);
    public WebDriver driver=null;
    public Alert alert=null;
    //获取Webdrive
    public  WebDriver getDriver(){

        if (InitConfigData.browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "F:\\自动化\\guge\\driver\\chromedriver.exe");
            driver = new ChromeDriver();
            logger.info("加载驱动,启动的是chromeDriver");
        }else if(InitConfigData.browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", "F:\\自动化\\guge\\driver\\geckodriver.exe");
            driver = new FirefoxDriver();

            logger.info("加载驱动,启动的是geckoDriver");
        }else {
            logger.info("无法识别的Driver");
        }
        return driver;
    }

    //识别一个元素
    public WebElement findElement(By by){
        WebElement element=null;
        try {
            element=driver.findElement(by);
            logger.info("找到元素"+getLocatorByElement(element,">"));
        }catch (NoSuchElementException e){
            e.printStackTrace();
            logger.error(by+"元素未找到");
        }
        return element;
    }

    //打开网址
    public void url(String url){
        driver.get(url);
        logger.info("打开网址");
    }
    public void click(By by){
        WebElement webElement=findElement(by);
        webElement.click();
        logger.info("对元素"+by+"做点击操作");
    }


    /**设置显示等待元素*/
    public void waitForElementLoad(final By by, int timeOut){
        logger.info("开始查找元素："+by);
        try{
            WebDriverWait wait = new WebDriverWait(driver, timeOut, 10000);
            wait.until(new ExpectedCondition<Boolean>() {

                public Boolean apply(WebDriver driver) {
                    WebElement element = driver.findElement(by);
                    return element.isDisplayed();
                }
            });
        } catch (TimeoutException e){
            logger.error("超时!! " + timeOut + " 秒之后还没找到元素 [" + by + "]");
            Assert.fail("超时!! " + timeOut + " 秒之后还没找到元素 [" + by + "]");
        }
        logger.info("找到了元素 [" + by + "]");
    }


    /**设置显示等待元素,默认10秒*/
    public void waitForElementLoad(By by){
        waitForElementLoad(by, 10);
    }
    //返回元素定位值
    public String getLocatorByElement(WebElement element,String ecxeptText){
        String text=element.toString();
        String except=null;
        try {
            except = text.substring(text.indexOf(ecxeptText)+1,text.length()-1);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("没有找到"+ecxeptText);
        }
        return except;
    }
    public String getText(By by){
        WebElement webElement=findElement(by);
        String text=webElement.getText();
        logger.info("获取元素内容,元素内容是:"+text);
        return text;
    }
    public void setKeys(By by,String value){
        WebElement webElement=findElement(by);
        clear(by);
        webElement.sendKeys(value);
        logger.info("在文本框中输入内容"+value);

    }

    public List<WebElement> findElements(By by){
        List<WebElement> elements=driver.findElements(by);
        logger.info("找到一组元素");
        return elements;
    }
    public void clear(By by){
        WebElement webElement=findElement(by);
        webElement.clear();
        logger.info("清空元素上的内容");
    }
    public void assertPage(String title){
        String title1=driver.getTitle();
        try {
            Assert.assertEquals(title,title1);
        }catch (AssertionError e){
            logger.error("预期页面是["+title+"]但实际页面是"+title1);
            Assert.fail("预期页面是["+title+"]但实际页面是"+title1);

        }
        logger.info("与预期结果一致");

      /*  if(title.equals(title1)){
            logger.info("是预期页面");
            return true;

        }else {
            logger.error("不是预期页面");
            return false;
        }*/
    }
    public Boolean isExiste(By by){
        try {
            driver.findElements(by);
            return true;
        }catch (NoSuchElementException e){
            logger.info((by.toString())+"元素不存在");
        }
        return false;
       /* WebElement webElement=findElement(by);
        Boolean isexiste=webElement.isDisplayed();
        if(isexiste==true){
            logger.info("该元素存在");
            return true;
        }else {
            logger.info("元素不存在");
            return false;
        }*/
    }
    public Boolean assertForText(String actual,String expected){

        try {
            Assert.assertEquals(actual,expected);
        }catch (AssertionError e){

            logger.error("实际文字是["+actual+"]但预期文字是"+expected);
            Assert.fail("实际文字是["+actual+"]但预期文字是"+expected);
            return false;
        }
        logger.info("与预期结果一致");
        return true;
     /*   if(text.equals(text1)){
            logger.info("文本与预期一致");
            return true;
        }else { logger.info("文本与预期不一致");
            return false;
        }*/
    }
    //页面中的iframe
    public void iFrame(String webElement){
    driver.switchTo().frame(webElement);
        logger.info("进入iframe");
    }
    //返回主文档
    public void content(){
        driver.switchTo().defaultContent();
        logger.info("返回主文档");
    }
    //弹窗输入内容
    public void alert(String value){
       alert=driver.switchTo().alert();
      alert.sendKeys(value);
        alert.accept();
    }//弹窗不输入内容
    public void alert(){
        alert=driver.switchTo().alert();
        alert.accept();
    }
    public void newPage(){
        Set<String> windows=driver.getWindowHandles();
        for(String handle:windows){
           driver.switchTo().window(handle);
        }
        logger.info("跳转到新的页面");
    }
      public void refresh(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().refresh();
        logger.info("刷新页面");
    }
}



