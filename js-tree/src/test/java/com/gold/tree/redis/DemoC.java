package com.gold.tree.redis;


import com.jpa.entity.RoleD;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;
//http://c.biancheng.net/view/4547.html
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoC {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RedisTemplate redisTemplate; //在MyRedisConfig文件中配置了redisTemplate的序列化之后， 客户端也能正确显示键值对了

    /**
     * 对象序列化
     */
    @Test
    public void testA() {
        RoleD role = new RoleD();
        role.setId(1L);
        role.setRoleName("role_name_1");
        role.setNote("note_l");
        logger.info(role.toString());
        String key = UUID.nameUUIDFromBytes(String.valueOf(System.currentTimeMillis()).getBytes()).toString();
        logger.info(StringUtils.repeat("=", 30) + ">");
        redisTemplate.opsForValue().set(key, role);
        Object o = redisTemplate.opsForValue().get(key);

        RoleD role1 = (RoleD) o;
        logger.info(role1.toString());
    }

    /**
     * Redis的基础事务和常用操作
     */
    @Test
    public void testC() {
        /*
         * 这里采用了 Lambda 表达式（注意，Java 8 以后才引入 Lambda 表达式）来为 SessionCallBack 接口实现了业务逻辑。从代码看，使用了 SessionCallBack 接口，从而保证所有的命令都是通过同一个 Redis 的连接进行操作的。
         * 在使用 multi 命令后，要特别注意的是，使用 get 等返回值的方法一律返回为空，因为在 Redis 中它只是把命令缓存到队列中，而没有去执行。使用 exec 后就会执行事务，执行完了事务后，执行 get 命令就能正常返回结果了。
         * 最后使用 redisTemplate.execute(callBack); 就能执行我们在 SessionCallBack 接口定义的 Lambda 表达式的业务逻辑，并将获得其返回值。执行代码后可以看到这样的结果
         * */
        SessionCallback callBack = new SessionCallback() {
            @Override
            public Object execute(RedisOperations ops) throws DataAccessException {
                ops.multi();
                String key = UUID.nameUUIDFromBytes(String.valueOf(System.currentTimeMillis()).getBytes()).toString();
                ops.boundValueOps(key).set("value1");
                //注意由于命令只是进入队列，而没有被执行，所以此处采用get命令，而value却返回为null
                String value = (String) ops.boundValueOps(key).get();
                logger.info("事务执行过程中，命令入队列，而没有被执行，所以value为空： value=" + value);
                //此时list会保存之前进入队列的所有命令的结果
                List list = ops.exec(); //执行事务
                //事务结束后，获取value1
                value = (String) redisTemplate.opsForValue().get(key);
                return value;
            }
        };
        //执行Redis的命令
        String value = (String) redisTemplate.execute(callBack);
        logger.info(value);

        /*
        需要再强调的是：这里打印出来的 value=null，是因为在事务中，所有的方法都只会被缓存到 Redis 事务队列中，而没有立即执行，
        所以返回为 null，这是在 Java 对 Redis 事务编程中开发者极其容易犯错的地方，一定要十分注意才行。
        如果我们希望得到 Redis 执行事务各个命令的结果，可以用这行代码：
        List list = ops.exec(); //执行事务
        这段代码将返回之前在事务队列中所有命令的执行结果，并保存在一个 List 中，我们只要在 SessionCallback 接口的 execute 方法中将 list 返回，
        就可以在程序中获得各个命令执行的结果了。
        */
    }


}
