package testIO;

import java.io.Serializable;
/*
创建一个Person类，将该类对象进行序列化与反序列化操作~~
要想使Person类的对象是可进行序列化操作的，就需要实现标识接口 Serializable
 */
public class Person implements Serializable {
    public static final long serialVersionUID = 475463534532L;
    //需要当前类提供一个全局常量

    private String name;
    private int age;
    private boolean isMale;

    public Person(String name, int age, boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public boolean isMale() {
        return isMale;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setMale(boolean male) {
        isMale = male;
    }

    @Override
    public String toString() {
        return "Person{"+"name='"+ name + '\'' +", age=" +age +", isMale="+ isMale + '}';
    }
}

