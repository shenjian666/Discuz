package pageHelper;

import page.Page_Vote;
import util.SeleniumUtil;

/**
 * Created by shenjian on 2018/5/9.
 */
public class HelperVotePage {
    public static void clickVote(SeleniumUtil seleniumUtil){
       seleniumUtil.waitForElementLoad(Page_Vote.FIND_TITLE_VOTE);
      seleniumUtil.click(Page_Vote.FIND_TITLE_VOTE);
    }
    public static void inputTitle(SeleniumUtil seleniumUtil,String text){
        seleniumUtil.waitForElementLoad(Page_Vote.FIND_INPUT_TITLE);
        seleniumUtil.setKeys(Page_Vote.FIND_INPUT_TITLE,text);
    }
    public static void inputFirst(SeleniumUtil seleniumUtil,String text){
        seleniumUtil.waitForElementLoad(Page_Vote.FIND_INPUT_FIRST);
        seleniumUtil.setKeys(Page_Vote.FIND_INPUT_FIRST,text);
    }
    public static void inputSecond(SeleniumUtil seleniumUtil,String text){
        seleniumUtil.waitForElementLoad(Page_Vote.FIND_INPUT_SECOND);
        seleniumUtil.setKeys(Page_Vote.FIND_INPUT_SECOND,text);
    }
    public static void inputThird(SeleniumUtil seleniumUtil,String text){
        seleniumUtil.waitForElementLoad(Page_Vote.FIND_INPUT_THIRD);
        seleniumUtil.setKeys(Page_Vote.FIND_INPUT_THIRD,text);
    }
    public static void radioClickFirst(SeleniumUtil seleniumUtil){
        seleniumUtil.waitForElementLoad(Page_Vote.FIND_RADIO_FIRST);
        seleniumUtil.click(Page_Vote.FIND_RADIO_FIRST);
    }
    public static void radioClickSceond(SeleniumUtil seleniumUtil){
        seleniumUtil.waitForElementLoad(Page_Vote.FIND_RADIO_SECOND);
        seleniumUtil.click(Page_Vote.FIND_RADIO_SECOND);
    }
    public static void radioClickThird(SeleniumUtil seleniumUtil){
        seleniumUtil.waitForElementLoad(Page_Vote.FIND_RADIO_THIRD);
        seleniumUtil.click(Page_Vote.FIND_RADIO_THIRD);
    }
    public static void radioClickBtn(SeleniumUtil seleniumUtil){
        seleniumUtil.waitForElementLoad(Page_Vote.FIND_RADIO_BTN);
        seleniumUtil.click(Page_Vote.FIND_RADIO_BTN);
    }
    public static void radioText(SeleniumUtil seleniumUtil){
        String firstpercent=seleniumUtil.getText(Page_Vote.RADIO_PERCENT_FIRST);
        String secondpercent= seleniumUtil.getText(Page_Vote.RADIO_PERCENT_SECOND);
        String thirdpercent= seleniumUtil.getText(Page_Vote.RADIO_PERCENT_THIRD);
        String firsttitle= seleniumUtil.getText(Page_Vote.RADIO_TITLE_FIRST);
        String secondtitle= seleniumUtil.getText(Page_Vote.RADIO_TITLE_SECOND);
        String thirdtitle= seleniumUtil.getText(Page_Vote.RADIO_TITLE_THIRD);
        System.out.println("第一个按钮的信息"+firsttitle+"\t"+firstpercent);
        System.out.println("第二个按钮的信息"+secondtitle+"\t"+secondpercent);
        System.out.println("第三个按钮的信息"+thirdtitle+"\t"+thirdpercent);
    }
    public static void getTitle(SeleniumUtil seleniumUtil){
        seleniumUtil.waitForElementLoad(Page_Vote.FIND_TITLE_CENTER);
        String title=seleniumUtil.getText(Page_Vote.FIND_TITLE_CENTER);
        System.out.println("当前投票主题的名称是"+title);
    }
}
