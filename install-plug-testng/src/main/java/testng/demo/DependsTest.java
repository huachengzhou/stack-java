package testng.demo;

import org.testng.annotations.Test;

/**
 * @Author noatnu
 * @Description TestNG 依赖测试 好用
 * @createDate 2019/7/28
 **/
public class DependsTest {

    @Test
    public void setupEnv() {
        System.out.println("this is setup Env");
    }

    /**
     * 有时候，我们需要按顺序来调用测试用例，  那么测试用例之间就存在依赖关系。 TestNG支持测试用例之间的依赖
     */
    @Test(dependsOnMethods = {"setupEnv"})
    public void testMessage() {
        System.out.println("this is test message");
    }

}
