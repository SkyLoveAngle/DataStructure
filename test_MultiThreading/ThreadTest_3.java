package test_MultiThreading;

public class ThreadTest_3 {
    public static void main(String[] args) {
        //为该分线程起个名字~~
        //方式一：在下面构造一个带参数的构造函数，初始化的时候直接命名~~
        MyThread_3 myThread_3 = new MyThread_3("Thread-1");
        //方式二：调用setName()函数
        //myThread_3.setName("分线程1");
        myThread_3.start();
        //给主线程起个名字~~
        Thread.currentThread().setName("主线程");
        for (int i=1;i<100;i++){
            if (i % 2 != 0){
                //Thread.currentThread().getName()--->获取当前进程名字
                System.out.println(Thread.currentThread().getName()+":"+ i);
            }
            //在主线程中，当运行到i=21的时候，主线程断开，进入Thread-1线程中~~
            if (i == 21){
                try {
                    myThread_3.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyThread_3 extends Thread{
    @Override
    public void run(){
        for (int i=1;i<100;i++){
            if (i % 2 == 0){
                //让进程睡眠一段时间，单位：ms
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Thread.currentThread().getName()--->获取当前进程名字
                System.out.println(Thread.currentThread().getName()+":"+ i);
            }
            //当i能够整除20的时候，释放当前线程的使用权~~
            if (i%20 == 0){
                Thread.currentThread().yield();
            }
        }
    }

    //创建一个带参数的构造函数
    public MyThread_3(String name){
        super(name);
    }
}
