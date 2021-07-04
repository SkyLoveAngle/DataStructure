package test_MultiThreading;

//1.创建一个继承于Thread类的子类
class MyThread extends Thread{
    //2.重写Thread类的run()
    @Override
    public void run(){
        for (int i=1;i<100;i++){
            if (i % 2 == 0){
                //Thread.currentThread().getName()--->获取当前进程名字
                System.out.println(Thread.currentThread().getName()+":"+ i);
            }
        }
    }
}

public class ThreadTest_1 {
    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread myThread_1 = new MyThread();
        //4. 通过此对象调用start()
        myThread_1.start();

        //注意事项：
        //myThread.run();
        //通过这种方式启动的线程不是多线程~~

        //如果此时，我们需要再次调用myThread线程，不可以直接再次调用start()，
        //而是需要重新创建对象后再调用~~
        MyThread myThread_2 = new MyThread();
        myThread_2.start();

        //测试一下多线程
        for (int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+":"+i*i);
        }
    }
}
