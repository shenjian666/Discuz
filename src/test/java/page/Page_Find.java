package page;

import org.openqa.selenium.By;

/**
 * Created by shenjian on 2018/5/9.
 */
public class Page_Find {
    //搜索文本框
    public static final By FIND_INPUT_CENTER=By.name("srchtxt");
    //搜索按钮
    public static final By FIND_LINK_BTN=By.name("searchsubmit");
    //找到的第一个帖子名
    public static final By FIND_LINK_TEXT=By.xpath("//*[@id=\"8\"]/h3/a/strong/font");
   //实际帖子名称
    public static final By LOGIN_TEXT_TITLE=By.id("thread_subject");
}
