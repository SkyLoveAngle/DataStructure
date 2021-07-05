package testReflection;

//通过反射获取类的方式
public class test01 {
    public static void main(String[] args) throws ClassNotFoundException{
        User user = new user1();
        System.out.println("这个角色是："+user.getName());

        //方式1：通过对象获得
        Class class1 = user.getClass();
        System.out.println(class1.hashCode());

        //方式2：使用forName获取
        Class class2 = Class.forName("testReflection.user1");
        System.out.println(class2.hashCode());

        //方式3:通过类名.class获得
        Class class3 = user1.class;
        System.out.println(class3.hashCode());

        //方式4：基本内置类型的包装类都有一个type属性（该方法有局限性）
        Class class4 = Integer.TYPE;
        System.out.println(class4);

        //获取class1的父类类型
        Class class5 = class1.getSuperclass();
        System.out.println(class5);
    }
}

//实体类
class User {
    public String name;
    private int id;
    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
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

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", id=" + id + ", age=" + age + '}';
    }
}


class user1 extends User {
    public user1() {
        this.setName("甲");
        this.setId(001);
        this.setAge(18);
    }
}

class user2 extends User {
    public user2() {
        this.setName("乙");
        this.setId(002);
        this.setAge(28);
    }
}
