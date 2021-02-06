package Homework0130;

public class test {
}

//class Person {
//
//    private String name;//实例成员变量
//    private  int age;
//    private String sex;
//    //默认构造函数   构造对象
//    public Person() {
//        this.name = "caocao";
//        this.age = 10;
//        this.sex = "男";
//    }
//    //带有3个参数的构造函数 注意此时形参的命名和属性的命名一样
//    public Person(String name,int age,String sex) {
//        this.name = name;
//        this.age = age;
//        this.sex = sex;
//    }
//    public void show(){
//        System.out.println("name: "+this.name+" age: "+this.age+" sex: "+this.sex);
//    }
//
//}
//class Main{
//    public static void main(String[] args) {
//        Person p1 = new Person();//调用不带参数的构造函数 如果程序没有提供会调用不带参数的构造函数
//        p1.show();
//        Person p2 = new Person("zhangfei",80,"男");//调用带有3个参数的构造函数
//        p2.show();
//    }
//}


//class Person {
//    private String name;//实例成员变量
//    private  int age;
//    private String sex;
//
//    //默认构造函数   构造对象
//    public Person() {
//        this.name = "caocao";
//        this.age = 10;
//        this.sex = "男";
//    }
//    //带有3个参数的构造函数 注意此时形参的命名和属性的命名一样
//    public Person(String name,int age,String sex) {
//        this.name = name;
//        this.age = age;
//        this.sex = sex;
//    }
//    public void eat() {
//        System.out.println(this.name+" 正在吃饭！");
//    }
//    public void show(){
//        System.out.println("name: "+this.name+" age: "+this.age+" sex: "+this.sex);
//        //在show方法当中，通过this引用来调用本类的eat方法
//        this.eat();
//    }
//}
//class Main{
//    public static void main(String[] args) {
//        Person p1 = new Person();
////调用不带参数的构造函数 如果程序没有提供会调用不带参数的构造函数
//        p1.show();
//        Person p2 = new Person("zhangfei",80,"男");//调用带有3个参数的构造函数
//        p2.show();
//    }
//}


class Person {
    private String name;//实例成员变量
    private  int age;
    private String sex;

    //默认构造函数   构造对象
    public Person() {
        //this调用构造函数
        this("sky", 12, "man");//必须放在第一行进行显示
    }

    //这两个构造函数之间的关系为重载。
    public Person(String name,int age,String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public void show() {
        System.out.println("name: "+name+" age: "+age+" sex: "+sex);
    }
}
class Main{
    public static void main(String[] args) {
        Person person = new Person();//调用不带参数的构造函数
        person.show();
    }
}
