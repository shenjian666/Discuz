package testcase;

import org.testng.annotations.Test;
import pageHelper.HelperLoginPage;

/**
 * Created by shenjian on 2018/5/9.
 */
public class Lt_FindPost extends BasicTestCase{
    @Test
    public  void Find(){
        HelperLoginPage.login(seleniumUtil,"test","123456");
    }
}
