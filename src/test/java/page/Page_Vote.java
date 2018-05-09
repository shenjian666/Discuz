package page;

import org.openqa.selenium.By;

/**
 * Created by shenjian on 2018/5/9.
 */
public class Page_Vote {
    //发起投票
    public static final By FIND_TITLE_VOTE=By.linkText("发起投票");
    //标题栏
    public static final By FIND_INPUT_TITLE=By.id("subject");
    //文本1
    public static final By FIND_INPUT_FIRST=By.xpath("//*[@id=\"pollm_c_1\"]/p[1]/input");
    //文本2
    public static final By FIND_INPUT_SECOND=By.xpath("//*[@id=\"pollm_c_1\"]/p[2]/input");
    //文本3
    public static final By FIND_INPUT_THIRD=By.xpath("//*[@id=\"pollm_c_1\"]/p[3]/input");
    //选项1
    public static final By FIND_RADIO_FIRST=By.id("option_1");
    //选项2
    public static final By FIND_RADIO_SECOND=By.id("option_2");
    //选项3
    public static final By FIND_RADIO_THIRD=By.id("option_3");
   //选项提交
    public static final By FIND_RADIO_BTN=By.name("pollsubmit");
    //第一个选项标题
    public static final By RADIO_TITLE_FIRST=By.xpath("//*[@id=\"poll\"]/div[2]/table/tbody/tr[1]/td[1]/label");
    //第二个选项标题
    public static final By RADIO_TITLE_SECOND=By.xpath("//*[@id=\"poll\"]/div[2]/table/tbody/tr[3]/td[1]/label");
    //第三个选项标题
    public static final By RADIO_TITLE_THIRD=By.xpath("//*[@id=\"poll\"]/div[2]/table/tbody/tr[5]/td[1]/label");
    //第一个选项百分比
    public static final By RADIO_PERCENT_FIRST=By.xpath("//*[@id=\"poll\"]/div[2]/table/tbody/tr[2]/td[2]");
    //第二个选项百分比
    public static final By RADIO_PERCENT_SECOND=By.xpath("//*[@id=\"poll\"]/div[2]/table/tbody/tr[4]/td[2]");
    //第三个选项百分比
    public static final By RADIO_PERCENT_THIRD=By.xpath("//*[@id=\"poll\"]/div[2]/table/tbody/tr[6]/td[2]");
   //标题内容
   public static final By FIND_TITLE_CENTER=By.id("thread_subject");

}
