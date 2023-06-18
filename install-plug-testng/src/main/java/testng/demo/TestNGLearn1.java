package testng.demo;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @Author noatnu
 * @Description 基本顺序测试 好用
 * @createDate 2019/7/28
 **/
public class TestNGLearn1 {

    @BeforeClass
    public void beforeClass() {
        System.out.println("this is before class");
    }


    @Test
    public void testNgLearn() {
        System.out.println("this is TestNG test case");
    }


    @AfterClass
    public void afterClass() {
        System.out.println("this is after class");
    }

}
