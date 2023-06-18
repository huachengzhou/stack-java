package testng.basic;

import org.testng.annotations.Test;

/**
 * @Author noatnu
 * @Description
 * @createDate 2019/7/28
 **/
public class TestTimeout {

    @Test(timeOut = 5000) // time in mulliseconds
    public void testThisShouldPass() throws InterruptedException {
        Thread.sleep(4000);
    }

    @Test(timeOut = 1000)
    public void testThisShouldFail() {
        while (true){
            // do nothing
        }

    }



}
