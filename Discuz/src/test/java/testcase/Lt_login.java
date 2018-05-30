package testcase;

import org.testng.annotations.Test;
import pageHelper.HelperLinkTextPage;
import pageHelper.HelperLoginPage;
import pageHelper.HelperReplyPage;

/**
 * Created by shenjian on 2018/5/7.
 */
public class Lt_login extends BasicTestCase{

  @Test
    public void login() throws Exception{
      HelperLoginPage.login(seleniumUtil,"test","123456");
     Thread.sleep(3000);
    HelperLoginPage.ft(seleniumUtil,"Hello World","大家好,哈哈哈哈哈哈哈哈");

    HelperLinkTextPage.back(seleniumUtil);

    HelperLoginPage.login(seleniumUtil,"admin","admin");

    HelperLinkTextPage.titleClick(seleniumUtil);

    HelperLoginPage.firstContent(seleniumUtil);

    HelperReplyPage.reply(seleniumUtil,"哇，你这个逗比");

  }
}
