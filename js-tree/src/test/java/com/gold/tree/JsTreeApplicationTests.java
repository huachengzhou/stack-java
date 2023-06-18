package com.gold.tree;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class JsTreeApplicationTests {



    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }


    @Test
     public void testA() {
        try {
            dataSource.getConnection().getClientInfo().stringPropertyNames().stream().forEach(s -> System.out.println("JsTreeApplicationTests.testA" +s));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
