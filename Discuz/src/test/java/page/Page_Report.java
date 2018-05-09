package page;

import org.openqa.selenium.By;

/**
 * Created by shenjian on 2018/5/8.
 */
public class Page_Report {


    //标题
    public static final By SUBMIT_INPUT_TITLE=By.id("subject");
    //内容
    public static final By SUBMIT_INPUT_CONTENT=By.xpath("/html/body");
    //发表帖子
    public static final By SUBMIT_LINK_FTBTN=By.id("postsubmit");

    //添加新版块
    public static final By LOGIN_LINK_NEWBLOCK=By.linkText("添加新版块");
    //新版块提交
    public static final By SUBMIT_LINK_NEWBLOCKBTN=By.id("submit_editsubmit");
}
