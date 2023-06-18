package testng.basic;

import org.testng.annotations.Test;

/**
 * @Author noatnu
 * @Description
 * @createDate 2019/7/28
 **/
public class TestRepeatThis {

    /**
     * 这个invocationCount确定TestNG应该运行这个测试方法的次数。
     */
    @Test(invocationCount = 10)
    public void repeatThis() {
        System.out.println("repeatThis " );
    }



}
