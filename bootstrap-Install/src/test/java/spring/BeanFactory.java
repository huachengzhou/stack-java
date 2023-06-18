package spring;

import java.util.List;
import java.util.stream.Collectors;

public class BeanFactory {
    public List<Object> createBeans(List<Class<?>> classList){
        return classList.stream().map(cls -> {
            return createBean(cls);
        }).collect(Collectors.toList());
    }

    public Object createBean(Class<?> cls){
        try {
            return new BeanWrapper(cls.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
