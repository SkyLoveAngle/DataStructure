package test_MultiThreading;

public class ThreadTest_2 {
    public static void main(String[] args) {
        MyThread myThread_1 = new MyThread();
        MyThread myThread_2 = new MyThread();

        myThread_1.start();
        myThread_2.start();

//        //创建Thread类的匿名子类的方式
//        new Thread(){
//            @Override
//            public void run(){
//
//            }
//        }.start();

    }
}

class MyThread_1 extends Thread{
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

class MyThread_2 extends Thread{
    @Override
    public void run(){
        for (int i=1;i<100;i++){
            if (i % 2 != 0){
                //Thread.currentThread().getName()--->获取当前进程名字
                System.out.println(Thread.currentThread().getName()+":"+ i);
            }
        }
    }
}