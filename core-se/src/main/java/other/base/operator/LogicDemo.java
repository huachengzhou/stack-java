package other.base.operator;

import org.apache.commons.lang3.RandomUtils;

import java.util.Random;
import java.util.logging.Logger;

/**
 * @Auther: zch
 * @Date: 2018/7/28 09:49
 * @Description:逻辑操作符
 */
public class LogicDemo {
    private final Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        new LogicDemo().boolA();
    }

    public void boolA() {
        int i = RandomUtils.nextInt(0,100);
        int j = RandomUtils.nextInt(0,101);
        logger.info(String.format("原始数据i: %d", i));
        logger.info(String.format("原始数据j %d", j));

        logger.info(String.format("i > j---boolean: %b", (i > j)));

        int a = new Random().nextInt(10);
        int b = new Random().nextInt(10);
        logger.info(String.format("原始数据a= %d", a));
        logger.info(String.format("原始数据b= %d", b));

        logger.info(String.format("a==b 结果: %b", (a == b)));
        logger.info(String.format("a>=b 结果: %b", (a >= b)));
        logger.info(String.format("a!=b 结果: %b", (a >= b)));
        logger.info(String.format("a<=b 结果: %b", (a <= b)));
        logger.info(String.format("a<b 结果: %b", (a < b)));
    }
}
