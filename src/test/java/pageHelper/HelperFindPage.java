package pageHelper;

import page.Page_Find;
import util.SeleniumUtil;

/**
 * Created by shenjian on 2018/5/9.
 */
public class HelperFindPage {

    public static void findPost(SeleniumUtil seleniumUtil,String text){
        seleniumUtil.waitForElementLoad(Page_Find.FIND_INPUT_CENTER);
        seleniumUtil.setKeys(Page_Find.FIND_INPUT_CENTER,text);
    }
    public static void findClick(SeleniumUtil seleniumUtil){
        seleniumUtil.waitForElementLoad(Page_Find.FIND_LINK_BTN);
        seleniumUtil.click(Page_Find.FIND_LINK_BTN);
    }
    public static void clickText(SeleniumUtil seleniumUtil){

        seleniumUtil.newPage();
        seleniumUtil.waitForElementLoad(Page_Find.FIND_LINK_TEXT);
        seleniumUtil.click(Page_Find.FIND_LINK_TEXT);
    }
    public static void assertText(SeleniumUtil seleniumUtil,String text){
        seleniumUtil.newPage();
        seleniumUtil.waitForElementLoad(Page_Find.LOGIN_TEXT_TITLE);
      String actual=seleniumUtil.getText(Page_Find.LOGIN_TEXT_TITLE);
        seleniumUtil.assertForText(actual,text);

    }
}
