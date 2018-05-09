package com.fbank.uitest.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**常用方法封装类*/
public class AppiumUtil {
	
	public AppiumDriver<WebElement> driver;
	/**日志输出对象*/
	public static Logger logger = Logger.getLogger(AppiumUtil.class);
	
	
	/**通过By查找某个元素*/
	public WebElement findElement(By by){
		WebElement ele = null;
		try{
			ele = driver.findElement(by);
			return ele;
		}catch(NoSuchElementException e){
			logger.error("Not find specific element: "+by,e);
			Assert.fail("Not find specific element: "+by, e);
		}
		return null;
	}

	/**通过String查找某个元素*/
	public WebElement findElement(String element){
		String uiauText = "new UiSelector().text(\""+element+"\")";
		WebElement ele = null;
		try{
			ele = ((AndroidDriver<WebElement>) driver).findElementByAndroidUIAutomator(uiauText);
			return ele;
		}catch(NoSuchElementException e){
			logger.error("Not find specific element: "+element,e);
			Assert.fail("Not find specific element: "+element, e);
		}
		return null;
	}
	
	
	/**通过By查找一组元素*/
	public List<WebElement> findElements(By by){
		return driver.findElements(by);
	}
	
	/**点击相同ID中的某个元素*/
	public void clickElementByIndex(By by, int index){
		WebElement element = findElements(by).get(index);
		try{
			element.click();
			logger.info("点击元素："+getLocatorByElement(element, ">")+"  index:"+index);
		}catch(Exception e){
			logger.error("点击元素"+getLocatorByElement(element, ">")+"  index:"+index+"失败",e);
			Assert.fail("点击元素"+getLocatorByElement(element, ">")+"  index:"+index, e);
		}
	
	}
	
	/**重新安装APP*/
	public void restartAPP(){
		logger.info("重新安装APP");
		driver.resetApp();
	}
	
	/**相同属性控件的数量*/
	public int countElements(By by){
		int size = findElements(by).size();
		return size;
	}
	
	/**是否包含某字符串*/
	public boolean isContainText(String text){
		String uiauText = "new UiSelector().text(\""+text+"\")";
		try{
			((AndroidDriver<WebElement>) driver).findElementByAndroidUIAutomator(uiauText);
			return true;
		}catch (NoSuchElementException e){
			logger.info("当前页面没有找到："+text);
		}
		return false;
	}
	
	
	/**根据顶部title判断当前页面是否是预期页面*/
	public void assertPage(String expected){
		sleep(2);
		By by = By.id("com.bank9f.weilicai:id/tvTitle");
		String actual = getText(by);
		try{
			Assert.assertEquals(actual, expected);
		} catch (AssertionError e){
			logger.error("预期文字是：["+expected+"],但实际文字是: ["+actual+"]");
			Assert.fail("预期文字是：["+expected+"],但实际文字是: ["+actual+"]");
		}
		logger.info("找到了对应title，当前页面正确：【"+actual+"】");
	}
	
	/**获取控件的内容*/
	public String getText(By by){
		String str = findElement(by).getText().trim();
		return str;
	}
	
	public String getText(By by, int index){
		String str = findElements(by).get(index).getText().trim();
		return str;
	}
	
	/**点击*/
	public void click(By Element){
		WebElement ele =findElement(Element);
		try{
			ele.click();
			logger.info("点击元素："+getLocatorByElement(ele, ">"));
		} catch (Exception e){
			e.printStackTrace();
			logger.error("点击元素"+getLocatorByElement(ele, ">")+"失败",e);
			Assert.fail("点击元素"+getLocatorByElement(ele, ">"), e);
		}
	}

	/**点击*/
	public void click(String element){
		String uiauText = "new UiSelector().text(\""+element+"\")";
		WebElement ele = ((AndroidDriver<WebElement>) driver).findElementByAndroidUIAutomator(uiauText);

		try{
			ele.click();
			logger.info("点击元素："+getLocatorByElement(ele, ">"));
		} catch (Exception e){
			e.printStackTrace();
			logger.error("点击元素"+getLocatorByElement(ele, ">")+"失败",e);
			Assert.fail("点击元素"+getLocatorByElement(ele, ">"), e);
		}
	}
	
	/**返回元素对应的定位值*/
	public String getLocatorByElement(WebElement element, String exceptText){
		String text = element.toString();
		String except = null;
		try{
			except = text.substring(text.indexOf(exceptText)+1, text.length()-1);
		} catch (Exception e){
			e.printStackTrace();
			logger.error("failed to find the String :  "+exceptText);
		}
		return except;
	} 
	
	
	public AppiumDriver<WebElement> getDriver(String url, DesiredCapabilities capabilities, String platform){
		if(platform.equalsIgnoreCase("android")){
			try {
				driver = new AndroidDriver<WebElement>(new URL(url), capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			return driver;
		}else{
			logger.error("请检查platform是否为android");
		}
		return driver;
	}
	
	/**关闭APP*/
	public void closeApp(String AppName){
		driver.closeApp();
		logger.info(AppName+"已经退出");
	}
	
	public void quit(String AppName){
		driver.quit();
		logger.info(AppName+"已经退出");
	}
	
	/**清空元素上的内容*/
	public void clear(By by){
		WebElement element = findElement(by);
		element.clear();
		logger.info("清空元素："+getLocatorByElement(element, ">")+"上的内容");
	}
	
	/**在输入框中输入内容*/
	public void editContext(By by, String str){
		WebElement element = findElement(by);
		clear(by);
		element.sendKeys(str);
		logger.info("在元素："+getLocatorByElement(element, ">")+"上输入内容："+str);
	}
	
	/**元素滑动*/
	public void swipe(int startX, int startY, int endX, int endY, int duration){
		driver.swipe(startX, startY, endX, endY, duration);
		logger.info("滑动页面：从("+startX+", "+startY+") 到 ("+endX+", "+endY+")");
	}
	
	/**单独处理手势滑动的行为*/
	public void fingerPWD(){
		try{
			if(isExist(By.id("com.bank9f.weilicai:id/vhandPassWordView")) && (this.getClass().getSimpleName() != "LoginPage_002_changeFingerPWD")){
				WebElement ele = findElement(By.id("com.bank9f.weilicai:id/vhandPassWordView"));
				int x = ele.getLocation().getX();
				int y = ele.getLocation().getY();
				int x1 = ele.getSize().getHeight();
				int y1 = ele.getSize().getWidth();
				TouchAction gesture = new TouchAction(driver).press(x+x1/2, y+y1/2).waitAction(100).moveTo(x1/2-x1/10, y1/2-y1/10).waitAction(100).moveTo(-x1/2+x1/10, 0).waitAction(100)
						  .moveTo(-x1/2+x1/10,0).release();
				logger.info("开始解除手势密码");
				gesture.perform();
				logger.info("手势密码解除成功");
			} else {
				logger.error("手势密码没有出现");
			}
		}catch(Exception e){
			
		}

	}
	
	/**设置手势密码*/
	public void settingFingerPWD(){
		if(isExist(By.id("com.bank9f.weilicai:id/vhandPassWordView"))){
			WebElement ele = findElement(By.id("com.bank9f.weilicai:id/vhandPassWordView"));
			int x = ele.getLocation().getX();
			int y = ele.getLocation().getY();
			int x1 = ele.getSize().getHeight();
			int y1 = ele.getSize().getWidth();
			TouchAction gesture = new TouchAction(driver).press(x+x1/2, y+y1/2).waitAction(1000).moveTo(x1/2-x1/10, y1/2-y1/10).waitAction(1000).moveTo(-x1/2+x1/10, 0).waitAction(1000)
					  .moveTo(-x1/2+x1/10,0).waitAction(100).moveTo(0, -y1/2+y1/10).release();
			logger.info("开始解除手势密码");
			gesture.perform();
			logger.info("手势密码解除成功");
			} else {
				logger.error("手势密码没有出现");
			}
	}
	
	/**暂停*/
	public void sleep(int sleepTime){
		try {
			TimeUnit.SECONDS.sleep(sleepTime);
			logger.info("暂停："+sleepTime+" 秒");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	/**设置显示等待元素*/
	public void waitForElementLoad(final By by, int timeOut){
		logger.info("开始查找元素："+by);
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeOut, 1000);
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
	
	/**设置显示等待元素*/
	public void waitForElementLoad(String element){
		logger.info("开始查找元素："+element);
		final String uiauText = "new UiSelector().text(\""+element+"\")";

		try{
			WebDriverWait wait = new WebDriverWait(driver, 10, 1000);
			wait.until(new ExpectedCondition<Boolean>() {
				
				public Boolean apply(WebDriver driver) {
					WebElement ele = ((AndroidDriver<WebElement>) driver).findElementByAndroidUIAutomator(uiauText);
					return ele.isDisplayed();
				}
			}); 
		} catch (TimeoutException e){
			logger.error("超时!! " + "10" + " 秒之后还没找到元素 [" + element + "]");
			Assert.fail("超时!! " + "10" + " 秒之后还没找到元素 [" + element + "]");
		}
		logger.info("找到了元素 [" + element + "]");
	}
	
	
	/**设置显示等待元素,默认10秒*/
	public void waitForElementLoad(By by){
		waitForElementLoad(by, 10);
	}
	
	/**校验文本是否与预期一致*/
	public void assertForText(String actual, String expected){
		try{
			Assert.assertEquals(actual, expected);
		} catch (AssertionError e){
			logger.error("期望的文字是 [" + expected + "] 但是找到了 [" + actual + "]");
			Assert.fail("期望的文字是 [" + expected + "] 但是找到了 [" + actual + "]");
		}
		logger.info("找到了期望的文字: [" + expected + "]");
	}
	
	/**左侧滑动*/
	public void swipeLeftSide(){
		logger.info("向左侧滑动");
		Dimension d =  driver.manage().window().getSize();
		int x = d.getWidth();
		int y = d.getHeight();
		swipe(x-x/10, y/2, x/10, y/2, 600);
	}
	
	/**右侧滑动*/
	public void swipeRightSide(){
		logger.info("向右侧滑动");
		Dimension d =  driver.manage().window().getSize();
		int x = d.getWidth();
		int y = d.getHeight();
		swipe(x/10, y/2, x-x/10, y/2, 500);
	}
	
	/**页面向上滑动半个屏幕*/
	public void swipeUpOfHalf(){
		Dimension d =  driver.manage().window().getSize();
		int x = d.getWidth();
		int y = d.getHeight();
		logger.info("mine页面向上滑动半屏");
		swipe(x/2, 3*y/4, x/2, y/4, 1000);
	}
	
	/**页面向xia滑动半个屏幕*/
	public void swipeDownOfHalf(){
		Dimension d =  driver.manage().window().getSize();
		int x = d.getWidth();
		int y = d.getHeight();
		logger.info("mine页面向上滑动半屏");
		swipe(x/2, y/4, x/2, 3*y/4, 1000);
	}
	
	/**校验元素是否存在*/
	public boolean isExist(By element){
		
		try{
			driver.findElement(element);
			return true;
		} catch (NoSuchElementException e){
			logger.info(element.toString()+"元素不存在");
		}
		return false;
	}
	
	/**校验元素是否存在*/
	public boolean isExist(String element){
		String uiauText = "new UiSelector().text(\""+element+"\")";
		try{
			((AndroidDriver<WebElement>) driver).findElementByAndroidUIAutomator(uiauText);
			return true;
		} catch (NoSuchElementException e){
			logger.info(element.toString()+"元素不存在");
		}
		return false;
	}
	
	//处理android键盘操作、BACK、HOME按键
	public void sendKeyBoard(int keyCode){
		logger.info("输入系统操作："+keyCode);
		((AndroidDriver<WebElement>) driver).pressKeyCode(keyCode);
	}
	
}
