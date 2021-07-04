package test_MultiThreading;


public class ThreadTest_5 {
    public static void main(String[] args) {
        //3.创建实现类的对象
        MyThread_5 myThread_5 = new MyThread_5();
        //4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象；
        Thread thread1 = new Thread(myThread_5);
        thread1.setName("线程1");
        //5.通过Thread类的对象 调用start()
        thread1.start();

        //在启动一个线程
        Thread thread2 = new Thread(myThread_5);
        thread2.setName("线程2");
        thread2.start();
    }
}

//1.创建一个实现Runnable接口的实现类
class MyThread_5 implements Runnable{
    //2.实现类去实现Runnable中的run()抽象方法
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if (i%2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}