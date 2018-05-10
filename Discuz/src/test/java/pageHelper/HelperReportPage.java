package pageHelper;

import page.Page_Report;
import util.SeleniumUtil;

/**
 * Created by shenjian on 2018/5/8.
 */
public class HelperReportPage {
    //输入所发帖的主题
    public static void inputTitle(SeleniumUtil seleniumUtil, String title) {
        seleniumUtil.waitForElementLoad(Page_Report.SUBMIT_INPUT_TITLE,10);
        seleniumUtil.setKeys(Page_Report.SUBMIT_INPUT_TITLE,title);

    }
    //输入所发帖的内容
    public static void inputBody(SeleniumUtil seleniumUtil,String body){
        seleniumUtil.iFrame("e_iframe");
        seleniumUtil.waitForElementLoad(Page_Report.SUBMIT_INPUT_CONTENT,10);
        seleniumUtil.setKeys(Page_Report.SUBMIT_INPUT_CONTENT,body);

    }
    //点击发帖按钮
    public static void ftBtn(SeleniumUtil seleniumUtil){
        seleniumUtil.content();
        seleniumUtil.waitForElementLoad(Page_Report.SUBMIT_LINK_FTBTN,10);
        seleniumUtil.click(Page_Report.SUBMIT_LINK_FTBTN);

    }
    //添加新版块
    public static void addNewBlock(SeleniumUtil seleniumUtil){
        seleniumUtil.iFrame("main");
        seleniumUtil.waitForElementLoad(Page_Report.LOGIN_LINK_NEWBLOCK);
        seleniumUtil.click(Page_Report.LOGIN_LINK_NEWBLOCK);

    }
    //确认新版块后提交
    public static void newBlockBtn(SeleniumUtil seleniumUtil){
      //  seleniumUtil.iFrame("main");
        seleniumUtil.waitForElementLoad(Page_Report.SUBMIT_LINK_NEWBLOCKBTN,10);
        seleniumUtil.click(Page_Report.SUBMIT_LINK_NEWBLOCKBTN);

    }
}
