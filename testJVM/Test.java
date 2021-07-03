package testJVM;



public class Test {
    public Object instance = null;
    private static int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1MB];
    public static void testGC() {
        Test test1 = new Test();
        Test test2 = new Test();
        test1.instance = test2;
        test2.instance = test1;
        test1 = null;
        test2 = null;
        // 强制jvm进行垃圾回收
        System.gc();
    }
    public static void main(String[] args) {
        testGC();
    }
}
