package testReflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

//反射操作注解
public class test12 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("testReflection.Student2");

        //通过反射获取注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations){
            System.out.println(annotation);
        }
        System.out.println("===========================================");

        //获得注解的value值
        TableSky tableSky = (TableSky)c1.getAnnotation(TableSky.class);
        String value = tableSky.value();
        System.out.println(value);
        System.out.println("===========================================");

        //获得类指定的注解
        Field field = c1.getDeclaredField("id");
        FieldSky annotation =field.getAnnotation(FieldSky.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}
@TableSky("db_SKY")
class Student2{
    @FieldSky(columnName = "db_id",type="int",length=10)
    private int id;
    @FieldSky(columnName = "db_age",type="int",length=10)
    private int age;
    @FieldSky(columnName = "db_name",type="varchar",length=5)
    private String name;

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" + "id=" + id + ", age=" + age + ", name='" + name + '\'' + '}';
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableSky{
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldSky{
    String columnName();
    String type();
    int length();
}