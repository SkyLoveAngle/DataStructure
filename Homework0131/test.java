package Homework0131;

public class test {
}
//
//class TestDemo{
// public int a;
// public static int count; }
//
// class Main{
//    public static void main(String[] args) {
//        TestDemo t1 = new TestDemo();
//        t1.a++;
//        TestDemo.count+=7;
//        System.out.println(t1.a);
//        System.out.println(TestDemo.count);
//        System.out.println("============");
//         TestDemo t2 = new TestDemo();
//         t2.a++;
//         TestDemo.count++;
//         System.out.println(t2.a);
//         System.out.println(TestDemo.count);
//         }
//        }

//class TestDemo{
//public int a;
//public static int count;
//public static void change() {
//    count = 100;
////a = 10; error 不可以访问非静态数据成员
//}
//
//}
//class Main{
//
//    public static void main(String[] args) {
//TestDemo.change();//无需创建实例对象 就可以调用
//System.out.println(TestDemo.count);
// }
//}

//class Main{
//    public static void main(String[] args) {
//        { //直接使用{}定义，普通方法块
//            int x = 10 ;
//            System.out.println("x1 = " +x);
//        }
//        int x = 100 ;
//        System.out.println("x2 = " +x);
//    }
//}

//
//class Person{
//    private String name;//实例成员变量
//    private  int age;
//    private String sex;
//
//    public Person() {
//        System.out.println("执行构造代码块!");
//    }
//    //实例代码块
//    {
//        this.name = "sky";
//        this.age = 12;
//        this.sex = "man";
//        System.out.println("执行实例代码块!");
//    }
//
//    public void show(){
//        System.out.println("name: "+name+" age: "+age+" sex: "+sex);
//    }
//}
//
//class Main {
//    public static void main(String[] args) {
//        Person p1 = new Person();
//        p1.show();
//    }
//}

//class Person{
//    private String name;//实例成员变量
//    private  int age;
//    private String sex;
//    private static int count = 0;//静态成员变量   由类共享数据 方法区
//
//    public Person(){
//        System.out.println("执行构造方法初始化！");
//    }
//
//    //实例代码块
//    {
//        this.name = "sky";
//        this.age = 12;
//        this.sex = "man";
//        System.out.println("执行实例代码块初始化!");
//    }
//
//    //静态代码块
//    static {
//        count = 10;//只能访问静态数据成员
//        System.out.println("执行静态代码块！");
//    }
//
//    public void show(){
//        System.out.println("name: "+name+" age: "+age+" sex: "+sex);
//    }
//
//}
//class Main {
//    public static void main(String[] args) {
//        Person p1 = new Person();
//        System.out.println("====================");
//        Person p2 = new Person();
//    }
//}




class OuterClass {
    private void outerMethod() {
        System.out.println("It's Method of OuterClass");
    }
    public static void main(String[] args) {
        OuterClass t = new OuterClass();
        OuterClass.Innerclass in = t.new Innerclass();
        in.innerMethod();
    }

    class Innerclass {
        public void innerMethod() {
            OuterClass.this.outerMethod();// 内部类成员方法与外部类成员方法同名时，使用this调用外部类的方法
            outerMethod();// 内部类没有同名方法时执行外部类的方法
        }
        private void outerMethod() {
            System.out.println("It's Method of Innerclass");
        }
    }
}