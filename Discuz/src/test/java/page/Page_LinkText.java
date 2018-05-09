package page;

import org.openqa.selenium.By;

/**
 * Created by shenjian on 2018/5/8.
 */
public class Page_LinkText {
    //默认版块title
    public static final By LOGIN_LINK_TITLE=By.linkText("默认版块");
    //发帖
    public static final By LOGIN_LINK_FTTITLE=By.xpath("//*[@id=\"newspecial\"]/img");
    //退出
    public static final By BACK_LINK_BUTTON=By.linkText("退出");
    //管理中心
    public static final By LOGIN_LINK_CENTER=By.linkText("管理中心");
    //论坛
    public static final By LOGIN_LINK_FORUM=By.linkText("论坛");
    //站点首页
    public static final By LOGIN_LINK_HOME=By.linkText("站点首页");
    //默认版块title
    public static final By LOGIN_LINK_NEWTITLE=By.linkText("新版块名称");
}
