package pageHelper;

import page.Page_LinkText;
import util.SeleniumUtil;

/**
 * Created by shenjian on 2018/5/8.
 */
public class HelperLinkTextPage {
    //点击默认版块
    public static void titleClick(SeleniumUtil seleniumUtil){
        seleniumUtil.waitForElementLoad(Page_LinkText.LOGIN_LINK_TITLE,10);
        seleniumUtil.click(Page_LinkText.LOGIN_LINK_TITLE);

    }
    //点击发帖
    public static void ftTitleClick(SeleniumUtil seleniumUtil){
        seleniumUtil.waitForElementLoad(Page_LinkText.LOGIN_LINK_FTTITLE,10);
        seleniumUtil.click(Page_LinkText.LOGIN_LINK_FTTITLE);

    }
    //退出当前用户
    public static void back(SeleniumUtil seleniumUtil){
        seleniumUtil.waitForElementLoad(Page_LinkText.BACK_LINK_BUTTON,10);
        seleniumUtil.click(Page_LinkText.BACK_LINK_BUTTON);

    }
    //点击管理中心
    public static void titleCenter(SeleniumUtil seleniumUtil){
        seleniumUtil.waitForElementLoad(Page_LinkText.LOGIN_LINK_CENTER,10);
        seleniumUtil.click(Page_LinkText.LOGIN_LINK_CENTER);

    }
    //点击论坛
    public static void forum(SeleniumUtil seleniumUtil){
        seleniumUtil.waitForElementLoad(Page_LinkText.LOGIN_LINK_FORUM,10);
        seleniumUtil.click(Page_LinkText.LOGIN_LINK_FORUM);

    }
    //站点首页
    public static void home(SeleniumUtil seleniumUtil){
        seleniumUtil.content();
        seleniumUtil.waitForElementLoad(Page_LinkText.LOGIN_LINK_HOME,10);
        seleniumUtil.click(Page_LinkText.LOGIN_LINK_HOME);

    }
    public static void newTitle(SeleniumUtil seleniumUtil){
        seleniumUtil.waitForElementLoad(Page_LinkText.LOGIN_LINK_NEWTITLE,10);
        seleniumUtil.click(Page_LinkText.LOGIN_LINK_NEWTITLE);

    }
}
