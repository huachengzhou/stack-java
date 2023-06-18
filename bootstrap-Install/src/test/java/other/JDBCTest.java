package other;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/9/25
 **/
public class JDBCTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    @Test
    public void jdbcTest(){
        ComboPooledDataSource comboPooledDataSource = (ComboPooledDataSource)context.getBean("comboPooledDataSource");
        DruidDataSource druidDataSource = (DruidDataSource)context.getBean("druidDataSource");
        System.out.println(comboPooledDataSource);
        System.out.println(druidDataSource);
        logger.info("简单测试!");
    }
}
