package testng.demo;

import org.testng.annotations.Test;

/**
 * @Author noatnu
 * @Description 异常测试
 * @createDate 2019/7/28
 **/
public class ExceptionTest {

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "NullPoint")
    public void testException() {
        Object o = null;
        if (o == null) {
            throw new IllegalArgumentException("NullPoint");
        }
    }

}
