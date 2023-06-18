package testng.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/**
 * @Author noatnu
 * @Description
 * @createDate 2019/7/28
 **/
public class TestMultipleThreads {

    /**
     * 使用Selenium打开Firefox浏览器并加载“yiibai.com”。
     */
    @Test(invocationCount = 3)
    public void loadTestThisWebsite() {

        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
//        System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.yiibai.com");
        System.out.println("Page Title is " + driver.getTitle());
        AssertJUnit.assertEquals("Google", driver.getTitle());
        driver.quit();

    }


    /**
     * threadPoolSize属性告诉TestNG创建一个线程池以通过多个线程运行测试方法。 使用线程池，会大大降低测试方法的运行时间。
     */
    @Test(invocationCount = 3, threadPoolSize = 3)
    public void testThreadPools() {

        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());

    }





}
