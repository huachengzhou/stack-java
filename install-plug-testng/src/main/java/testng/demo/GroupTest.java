package testng.demo;

import org.testng.annotations.Test;

/**
 * @Author noatnu
 * @Description 组测试
 * @createDate 2019/7/28
 **/
public class GroupTest {

    @Test(groups = {"systemtest"})
    public void testLogin() {
        System.out.println("this is test login");
    }

    @Test(groups = {"functiontest"})
    public void testOpenPage() {
        System.out.println("this is test Open Page");
    }

    @Test(testName = "testsssss",groups = {"functiontest","systemtest"})
    public void test(){

    }

}
