package testng.basic;

import org.testng.annotations.Test;

/**
 * @Author noatnu
 * @Description 运行时异常
 * @createDate 2019/7/28
 **/
public class TestRuntime {

    /**
     * 此示例显示如何测试运行时异常。 如果divisionWithException()方法抛出一个运行时异常 — ArithmeticException，它会获得通过。
     */
    @Test(expectedExceptions = ArithmeticException.class)
    public void divisionWithException() {
        int i = 1 / 0;
        System.out.println("After division the value of i is :"+ i);


        /**
         *  C:\Users\noatn\.IntelliJIdea2017.3\system\temp-testng-customsuite.xml
         *
         *  <?xml version="1.0" encoding="UTF-8"?>
         * <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
         <suite name="Default Suite">
         <test name="install-plug-study">
         <classes>
         <class name="com.testng.basic.TestRuntime">
         <methods>
         <include name="divisionWithException"/>
         </methods>
         </class> <!-- com.testng.basic.TestRuntime -->
         </classes>
         </test> <!-- install-plug-study -->
         </suite> <!-- Default Suite -->
         */
    }



}
