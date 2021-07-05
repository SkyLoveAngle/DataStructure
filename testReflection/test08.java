package testReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName ("testReflection.User") ;
        //获得类的名字
        System.out.println(c1.getName()); //获得包名 +类名.
        System.out.println(c1 . getSimpleName()); //获得类名
        System.out.println("==============================");

        // 获得类的属性
        Field[] fields = c1.getFields();//只能找到public修饰的属性
        for (Field field : fields) {
            System. out . println(field);
        }
        System.out.println("==============================");
        fields = c1.getDeclaredFields();//获取全部的属性
        for (Field field : fields) {
            System. out . println(field);
        }
        System.out.println("==============================");

        //获得指定属性的值
        Field name = c1. getDeclaredField("name") ;
        System.out.println(name) ;
        System.out.println("============================");

        //获得类的方法
        Method[] methods = c1. getMethods(); // 获得本类及其父类的全部public方法
        for (Method method : methods) {
            System.out.println("正常的:" + method);
        }
        System.out.println("============================");
        methods = c1. getDeclaredMethods(); // 获得本类的所有方法
        for (Method method : methods) {
             System.out.println("getDeclaredMethods : "+method) ;
        }
        System.out.println("============================");
         //获得指定方法
        // 为什么要添加参数？因为JAVA中的重载，如果方法名一样没有添加参数就会出错
        Method getName = c1. getMethod("getName",null) ;
        Method setName = c1. getMethod("setName",String.class);
        System.out.println(getName);
        System.out.println(setName) ;
        System.out.println("============================");


        //获得指定的构造器
        Constructor[] constructors = c1. getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("public修饰："+constructor);
        }
        System.out.println("============================");
        constructors = c1. getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("全部：" + constructor);
        }
        System.out.println("============================");
        //获得指定的构造器
        Constructor declaredConstructor = c1. getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println("指定:"+declaredConstructor);
        }
}
