package test_MultiThreading;


public class FlagStopThread {
    //使用标志位isQuit标识是否继续执行线程中的任务，true中断，false继续执行
    private static class MyRunnable implements Runnable {
        public volatile boolean isQuit = false;
        @Override
        public void run() {
            while (!isQuit) {
                System.out.println(Thread.currentThread().getName()+ ": 别管我，我忙着转账呢!");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+ ":好！停止转账！");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable target = new MyRunnable();
        Thread thread = new Thread(target, "李四");
        System.out.println(Thread.currentThread().getName()+ ": 让李四开始转账。");
        thread.start();
        Thread.sleep( 1000);
        System.out.println(Thread.currentThread().getName()+ ": 老板来电话了，得赶紧通知李四对方是个骗子！");
        target.isQuit = true;
    }
}