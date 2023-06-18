package other.jdk8.v1;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.Test;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author noatn
 * @Description
 * @createDate 2019/5/11
 **/
public class StreamDemoA {

    /**
     * 流创建
     */
    @Test
    public void createStream() {
        List<Double> doubleList = Stream.generate(() -> RandomUtils.nextDouble(300d,10000)).limit(30).collect(Collectors.toList());

        Stream<Double> doubleStream = null;
        {
            doubleStream = doubleList.stream().distinct();
            doubleStream = doubleList.stream().limit(3);
            doubleStream = doubleList.stream().filter(aDouble -> aDouble > 3);
            doubleStream = doubleList.stream().skip(4);
            doubleStream = doubleList.stream().sorted();
            doubleStream = doubleList.stream().sequential();
            doubleStream = doubleList.stream().unordered();
        }
        {
            Stream stream = Stream.empty();
        }
        {
            Stream<String> song = Stream.of("stream");
        }
        {
            List<Double> doubles = Lists.newArrayList();
            doubles.stream().filter(aDouble -> aDouble>0).forEachOrdered(aDouble -> {
                System.out.println("dg");
            });
        }
    }

}
