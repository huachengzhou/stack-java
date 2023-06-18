package testng.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @Author noatnu
 * @Description
 * @createDate 2019/7/28
 **/
public class LoggerTest {
    private final Logger logger = LoggerFactory.getLogger(getClass()) ;
    @Test
    public void testLogger(){
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warning message");
        logger.error("error message");
        logger.warn("login message");
    }


}
