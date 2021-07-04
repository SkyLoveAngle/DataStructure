package test_MultiThreading;

public class ThreadTest_6 {
    public static void main(String[] args) {
        MyThread_6 window = new MyThread_6();
        Thread window1 = new Thread(window);
        Thread window2 = new Thread(window);
        Thread window3 = new Thread(window);
        window1.setName("窗口1");
        window2.setName("窗口2");
        window3.setName("窗口3");
        window1.start();
        window2.start();
        window3.start();
    }
}

class MyThread_6 implements Runnable{   //这儿的同步监视器就是 this
    private int ticket = 100;
    @Override
    public void run() {
        while(true){
            test();
        }
    }

    public synchronized void test() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            ticket--;
        }
    }
}