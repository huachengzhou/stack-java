package spring;

public class BeanWrapper {
    private Object bean;

    public BeanWrapper(Object bean) {
        this.bean = bean;
    }

    @Override
    public String toString() {
        return this.bean.toString();
    }
}
