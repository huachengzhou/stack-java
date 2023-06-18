package spring;

import java.util.Arrays;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        isit();
    }

    public static void isit(){
        List<Class<?>> classes = Arrays.asList(new Class[]{MyBean1.class});
        List<Object> ins = new BeanFactory().createBeans(classes);
        System.out.println(ins.toString());
    }
}
