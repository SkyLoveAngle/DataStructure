package testJVM;

public class test1 {
    public static void main(String[] args) {
        int m=1;
        int n=2;
        swap1(m,n);
        System.out.printf("main:m=%s,n=%s%n",m,n);
    }

    private static void swap1(int m, int n) {
        int tmp = m;
        m = n;
        n=tmp;
        Person p1 = new Person("p1");
        Person p2 = new Person("p2");
        swap2(p1,p2);
        System.out.printf("swap1:p1=%s,p2=%s%n",p1.name,p2.name);
    }

    private static void swap2(Person p1,Person p2) {
        Person tmp = p1;
        p1=p2;
        p2=tmp;
        System.out.printf("swap2:p1=%s,p2=%s%n",p1.name,p2.name);
    }

    static class Person{
        String name;
        public Person(String name){this.name = name;}
    }

}

