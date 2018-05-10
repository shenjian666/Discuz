package testcase;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import pageHelper.HelperLinkTextPage;
import pageHelper.HelperLoginPage;
import pageHelper.HelperReplyPage;
import pageHelper.HelperReportPage;

/**
 * Created by shenjian on 2018/5/8.
 */
public class Lt_AddForum extends BasicTestCase{
    @Test
    public void towtest() throws Exception{
        //登录
        HelperLoginPage.login(seleniumUtil,"admin","admin");

     HelperLinkTextPage.titleCenter(seleniumUtil);

        //新页面添加论坛
        HelperLoginPage.newPagePwd(seleniumUtil);
        //返回首页
       HelperLinkTextPage.home(seleniumUtil);
        seleniumUtil.newPage();
        //退出管理员
        HelperLinkTextPage.back(seleniumUtil);
        //登陆普通用户
        HelperLoginPage.login(seleniumUtil,"test","123456");
        Thread.sleep(3000);
        HelperLinkTextPage.newTitle(seleniumUtil);
        HelperLinkTextPage.ftTitleClick(seleniumUtil);
        HelperReportPage.inputTitle(seleniumUtil,"haotest");
        HelperReportPage.inputBody(seleniumUtil,"haotest,你值得拥有");
        HelperReportPage.ftBtn(seleniumUtil);
        HelperReplyPage.reply(seleniumUtil,"哇，你这个逗比");


    }
}
