package pageHelper;

import page.Page_Login;
import page.Page_LinkText;
import util.SeleniumUtil;

/**
 * Created by shenjian on 2018/5/7.
 */
public class HelperLoginPage {
    //输入用户名
    public static void inputUsername(SeleniumUtil seleniumUtil,String name){
        seleniumUtil.waitForElementLoad(Page_Login.LOGIN_INPUT_USERNAME,10);
        seleniumUtil.setKeys(Page_Login.LOGIN_INPUT_USERNAME,name);

    }
    //输入密码
    public static void inputPassword(SeleniumUtil seleniumUtil,String pwd){
        seleniumUtil.waitForElementLoad(Page_Login.LOGIN_INPUT_PASSWORD,10);
        seleniumUtil.setKeys(Page_Login.LOGIN_INPUT_PASSWORD,pwd);

    }
    //点击登录
    public static void loginBtn(SeleniumUtil seleniumUtil){
        seleniumUtil.waitForElementLoad(Page_Login.LOGIN_LINK_LOGINBTN,10);
        seleniumUtil.click(Page_Login.LOGIN_LINK_LOGINBTN);

    }


    //用户名+密码 直接登录
    public static void login(SeleniumUtil seleniumUtil,String name,String pwd)  {
        inputUsername(seleniumUtil,name);
        inputPassword(seleniumUtil,pwd);
        loginBtn(seleniumUtil);

    }


    //发帖内容+提交
    public static void ft(SeleniumUtil seleniumUtil,String title,String body) throws Exception {
       HelperLinkTextPage.titleClick(seleniumUtil);

        HelperLinkTextPage.ftTitleClick(seleniumUtil);

        HelperReportPage.inputTitle(seleniumUtil,title);

        HelperReportPage.inputBody(seleniumUtil,body);

        HelperReportPage. ftBtn(seleniumUtil);

    }


    //第一个帖子
    public static void firstContent(SeleniumUtil seleniumUtil){
        seleniumUtil.waitForElementLoad(Page_Login.LOGIN_LINK_CONTENT,10);
        seleniumUtil.click(Page_Login.LOGIN_LINK_CONTENT);

    }
    //删除主题
    public static void defaultContent(SeleniumUtil seleniumUtil){
        seleniumUtil.waitForElementLoad(Page_Login.DEFAULT_LINK_CONTENT,10);
        seleniumUtil.click(Page_Login.DEFAULT_LINK_CONTENT);

    }
    //删除确定
    public static void defaultBtn(SeleniumUtil seleniumUtil){
        seleniumUtil.waitForElementLoad(Page_Login.DEFAULT_LINK_BUTTON,10);
        seleniumUtil.click(Page_Login.DEFAULT_LINK_BUTTON);

    }
    public static void deletePost(SeleniumUtil seleniumUtil) throws InterruptedException {
        HelperLinkTextPage.titleClick(seleniumUtil);
        firstContent(seleniumUtil);
        defaultContent(seleniumUtil);

        defaultBtn(seleniumUtil);
    }


    //管理中心输入密码
    public static void newPassword(SeleniumUtil seleniumUtil,String pwd){
        seleniumUtil.waitForElementLoad(Page_Login.LOGIN_INPUT_NEWPASSWORD,10);
        seleniumUtil.setKeys(Page_Login.LOGIN_INPUT_NEWPASSWORD,pwd);

    }
    //管理中心登录
    public static void adminBtn(SeleniumUtil seleniumUtil){
        seleniumUtil.waitForElementLoad(Page_Login.SUBMIT_LINK_ADMINBTN,10);
        seleniumUtil.click(Page_Login.SUBMIT_LINK_ADMINBTN);

    }

    public static void newPagePwd(SeleniumUtil seleniumUtil) throws InterruptedException {
        seleniumUtil.newPage();
         newPassword(seleniumUtil,"admin");
         adminBtn(seleniumUtil);
         HelperLinkTextPage.forum(seleniumUtil);

        HelperReportPage.addNewBlock(seleniumUtil);
        HelperReportPage.newBlockBtn(seleniumUtil);
    }



}
