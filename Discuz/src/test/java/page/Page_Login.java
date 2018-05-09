package page;

import org.openqa.selenium.By;

/**
 * Created by shenjian on 2018/5/7.
 */
public class Page_Login {

    //用户名*登录
    public static final  By LOGIN_INPUT_USERNAME = By.name("username");
    //密码*登录
    public static final  By LOGIN_INPUT_PASSWORD = By.name("password");
    //登录按钮
    public static final  By LOGIN_LINK_LOGINBTN = By.xpath("//*[@id=\"lsform\"]/div/div/table/tbody/tr[2]/td[3]/button");




    //第一个帖子
    public static final By LOGIN_LINK_CONTENT=By.xpath("//tbody/tr/th/a[2]");
    //删除主题
    public static final By DEFAULT_LINK_CONTENT=By.linkText("删除主题");
   //删除按钮
   public static final By DEFAULT_LINK_BUTTON=By.name("modsubmit");

    //用户名密码
    public static final  By LOGIN_INPUT_NEWPASSWORD = By.name("admin_password");
    //管理员提交按钮
    public static final By SUBMIT_LINK_ADMINBTN=By.name("submit");


}
