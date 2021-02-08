package Homework0202;

//public class test {
//    public static void main(String[] args) {
//        boolean b=true?false:true==true?false:true;
//        System.out.println(b);
//    }
//}

//class TestTeacher {
//    public static void main(String[] args) {
//        Teacher t1=new Teacher("admin","2424");
//        t1.setAge(20);//通过对象调用实例方法
//        t1.introduce();
//        //类名调用静态方法
//        Teacher.printCount();
//        //对象名调用静态方法
//        t1.printCount();
//    }
//}
//class Teacher {
//    //成员变量
//    private String name;//实例变量
//    private String password;//实例变量
//    static int count=0;//静态变量
//    private int age;//实例变量
//    //构造方法
//    public Teacher(String n,String p) {
//        this.name=n;
//        this.password=p;
//        count++;//每创建一个对象，计数加一
//    }
//    //成员方法
//    //实例方法——输出信息
//    public void introduce() {
//        System.out.println("姓名："+name+" 密码："+password+" 年龄"+age+" count:"+count);
//    }
//    //实例变量——设置年龄
//    public void setAge(int a) {
//        age=a;
//    }
//    //静态方法——输出count-只能调用静态变量
//    static void printCount() {
//        System.out.println("静态方法count:"+count);
//    }
//}


//class Test{
//    static boolean foo(char c){
//        System.out.println(c);
//        return true;
//    }
//    public static void main(String[] args){
//        int i=0;
//        for(foo('A');foo('B')&&(i<2);foo('C')){
//            i++;
//            foo('D');
//        }
//    }
//}


//class Test2{
//    public static void stringReplace(String str){
//        str = str.replace('j','i');
//    }
//    public static void bufferReplace(StringBuffer sbf){
//        sbf = sbf.append("C");
//    }
//    public static void main(String args[]){
//        String strText=new String("java");
//        StringBuffer sbfText = new StringBuffer("java");
//        stringReplace(strText);
//        bufferReplace(sbfText);
//        System.out.println(strText+sbfText);
//    }
//}


//class Example{
//    String str=new String("good");
//    char[]ch={'a','b','c'};
//    public static void main(String args[]){
//        Example ex=new Example();
//        ex.change(ex.str,ex.ch);
//        System.out.print(ex.str+" and ");
//        System.out.print(ex.ch);
//}
//public void change(String str,char ch[]){
//    //引用类型变量，传递的是地址，属于引用传递。
//    str="test ok";
//    ch[0]='g';
//    }
//}



