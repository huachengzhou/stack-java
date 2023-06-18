package testng.demo;

import org.testng.annotations.Test;

/**
 * @Author noatnu
 * @Description TestNG忽略测试 好用
 * @createDate 2019/7/28
 **/
public class TesgNGIgnore {

    /**
     * 有时候测试用例还没准备好， 可以给测试用例加上@Test(enable = false)，  来禁用此测试用例
     */
    @Test(enabled = false)
    public void testIgnore() {
        System.out.println("This test case will ignore");
    }

}
