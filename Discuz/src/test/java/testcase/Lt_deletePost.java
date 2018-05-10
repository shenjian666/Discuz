package testcase;

import pageHelper.HelperLoginPage;

/**
 * Created by shenjian on 2018/5/8.
 */
public class Lt_deletePost extends BasicTestCase {
    public void delete() throws Exception {
        //登陆
        HelperLoginPage.login(seleniumUtil, "admin", "admin");
        Thread.sleep(5000);
        //删除
        HelperLoginPage.deletePost(seleniumUtil);
    }
}