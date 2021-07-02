package testIO;

import org.junit.Test;
import java.io.*;

public class Buffered_Stream_Test {
    /*
    缓冲流的作用就是提升流的读写操作效率！
    因为内部提供了一个缓冲区
     */
    @Test
    //实现非文本数据的复制
    public void bufferedStreamTest(){
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //1.创建File类的对象，指明读入和写出文件
            File srcFile  = new File("src\\IU.jpg");
            File destFile = new File("src\\IU3.jpg");
            //2.创建输入输出流（两步走——先造节点流，再建缓冲流）
            FileInputStream fileInputStream = new FileInputStream(srcFile);
            FileOutputStream fileOutputStream = new FileOutputStream(destFile);

            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //3.数据的读入和写出操作
            byte[] buffer = new byte[10];
            int len;
            while((len = bufferedInputStream.read(buffer)) != -1){
                bufferedOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        //4.关闭流资源（注意先后顺序！）
        //要求：先关闭外层的流，在关闭内层的流！
        try {
            if (bufferedOutputStream != null){
                bufferedOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (bufferedInputStream != null){
                bufferedInputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //其实在关闭外层流的同时，内层流也会自动的关闭，所以内层流的关闭可以省略！
//        fileOutputStream.close();
//        fileInputStream.close();
    }





    public void copyFileWithBuffer(String srcPath,String destPath){
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //1.创建File类的对象，指明读入和写出文件
            File srcFile  = new File(srcPath);
            File destFile = new File(destPath);
            //2.创建输入输出流（两步走——先造节点流，再建缓冲流）
            FileInputStream fileInputStream = new FileInputStream(srcFile);
            FileOutputStream fileOutputStream = new FileOutputStream(destFile);

            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //3.数据的读入和写出操作
            byte[] buffer = new byte[1024];
            int len;
            while((len = bufferedInputStream.read(buffer)) != -1){
                bufferedOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        //4.关闭流资源（注意先后顺序！）
        //要求：先关闭外层的流，在关闭内层的流！
        try {
            if (bufferedOutputStream != null){
                bufferedOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (bufferedInputStream != null){
                bufferedInputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestCopyFileWithBuffer(){
        long start = System.currentTimeMillis();

        String srcpath = "E:\\JAVA数据结构\\src\\AAA.mp4";
        String destPath = "E:\\JAVA数据结构\\src\\CCC.mp4";
        copyFileWithBuffer(srcpath,destPath);

        long end = System.currentTimeMillis();
        System.out.println("AAA视频复制为CCC视频操作花费的具体时间为："+(end - start)+"ms!");
    }
}
