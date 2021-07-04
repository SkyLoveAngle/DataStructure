package test_MultiThreading;

public class ThreadTest_4 {
    public static void main(String[] args) {
        MyThread_4 window1 = new MyThread_4();
        MyThread_4 window2 = new MyThread_4();
        MyThread_4 window3 = new MyThread_4();
        window1.setName("窗口1");
        window2.setName("窗口2");
        window3.setName("窗口3");
        window1.start();
        window2.start();
        window3.start();
    }
}

class MyThread_4 extends Thread{
    private static int ticket = 100;
    @Override
    public void run(){
        while(true){
            test();
        }
    }
    private static synchronized void test(){
            if (ticket > 0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                     e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+ ":卖票，票号为："+ ticket);
                ticket--;
            }
    }
}