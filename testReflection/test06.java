package testReflection;

public class test06 {
    static{
    System.out.println("Main类被加载！");
}
    public static void main(String[] args) throws ClassNotFoundException {

        //产生类的引用方法
        //主动引用
        Son son = new Son();

        //反射也会产生主动引用
        Class.forName("testReflection.Son");

        //不会产生类的引用方法
        //子类调用父类的变量
        System.out.println(Son.b);

        //定义一个数组，只是开辟空间
        Son[] array = new Son[10];

        //调用子类的常量池中的常量
        System.out.println(Son.M);
    }
}

class Father {
    static int b = 2;
    static {
        System.out.println("父类被加载！");
    }
}
    class Son extends Father {
        static {
            System. out. println("子类被加载!");
            m =300;
        }
        static int m =100;
        static final int M = 1;
}
