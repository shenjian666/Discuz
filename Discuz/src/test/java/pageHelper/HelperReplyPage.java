package pageHelper;

import page.Page_Reply;
import util.SeleniumUtil;

/**
 * Created by shenjian on 2018/5/8.
 */
public class HelperReplyPage {
    //回复内容
    public static void replyContent(SeleniumUtil seleniumUtil, String content){
        seleniumUtil.waitForElementLoad(Page_Reply.REPLY_INPUT_CONTENT,10);
        seleniumUtil.setKeys(Page_Reply.REPLY_INPUT_CONTENT,content);

    }
    //回复按钮
    public static void replyBTN(SeleniumUtil seleniumUtil){
        seleniumUtil.waitForElementLoad(Page_Reply.REPLY_LINK_BUTTON,10);
        seleniumUtil.click(Page_Reply.REPLY_LINK_BUTTON);

    }
    //回复内容加提交
    public static void reply(SeleniumUtil seleniumUtil,String content){
        replyContent(seleniumUtil,content);
        replyBTN(seleniumUtil);
    }
}
