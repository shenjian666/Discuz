package testcase;

import org.testng.annotations.Test;
import pageHelper.HelperLinkTextPage;
import pageHelper.HelperLoginPage;
import pageHelper.HelperReportPage;
import pageHelper.HelperVotePage;

/**
 * Created by shenjian on 2018/5/9.
 */
public class Lt_Vote extends BasicTestCase{
    @Test
      public void vote() throws InterruptedException {
          HelperLoginPage.login(seleniumUtil,"admin","admin");
        Thread.sleep(3000);
          HelperLinkTextPage.titleClick(seleniumUtil);
          HelperLinkTextPage.ftTitleClick(seleniumUtil);
          HelperVotePage.clickVote(seleniumUtil);
          HelperVotePage.inputTitle(seleniumUtil,"你喜欢玩什么");
        HelperVotePage.inputFirst(seleniumUtil,"电子游戏");
        HelperVotePage.inputSecond(seleniumUtil,"篮球");
        HelperVotePage.inputThird(seleniumUtil,"足球");
        HelperReportPage.inputBody(seleniumUtil,"喜欢什么就选什么，别客气");
        HelperReportPage.ftBtn(seleniumUtil);
        HelperVotePage.radioClickFirst(seleniumUtil);
        HelperVotePage.radioClickBtn(seleniumUtil);
        Thread.sleep(3000);
        HelperVotePage.getTitle(seleniumUtil);
        HelperVotePage.radioText(seleniumUtil);

      }
}
