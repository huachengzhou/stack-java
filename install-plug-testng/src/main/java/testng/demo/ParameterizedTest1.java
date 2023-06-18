package testng.demo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @Author noatnu
 * @Description TestNG参数化测试
 * @createDate 2019/7/28
 **/
public class ParameterizedTest1 {

    @Test
    @Parameters({"1","2"})
    public void paraTest(String test1) {
        System.out.println("This is " + test1);
    }
}
