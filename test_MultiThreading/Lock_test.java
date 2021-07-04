package test_MultiThreading;

import java.util.concurrent.locks.ReentrantLock;

public class Lock_test {
    public static void main(String[] args) {
        Window window = new Window();
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

class Window implements Runnable{
    private int ticket = 100;
    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock(); //默认false
    @Override
    public void run() {
        while(true) {
            try {
                //2.调用锁定方法:lock()
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }finally{
                //3.调用解锁方法：unlock()
                lock.unlock();
            }
        }
    }
}