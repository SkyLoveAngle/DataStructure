package testIO;

import org.junit.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStream_FileOutputStream_Test {

    //实现对图片的复制操作
    @Test
    public void test_FileInputStream_FileOutputStream() throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //1.创建File类的对象，指明读入和写出文件
            File srcFile = new File("src\\IU.jpg");
            File destFile = new File("src\\IU2.jpg");
            //2.创建输入流和输出流的对象
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);
            //3.数据的读入和写出操作
            byte[] buffer = new byte[5];
            int len;//记录每次读取的字节的个数
            while((len = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源（注意先后顺序！）
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //实现对指定路径下的视频文件的复制操作
    public void copyFile(String srcPath,String destPath){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //1.创建File类的对象，指明读入和写出文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2.创建输入流和输出流的对象
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);
            //3.数据的读入和写出操作
            byte[] buffer = new byte[1024];
            /*
            这个地方1024的取值是有考究的~~
             */
            int len;//记录每次读取的字节的个数
            while((len = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源（注意先后顺序！）
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();

        String srcpath = "E:\\JAVA数据结构\\src\\AAA.mp4";
        String destPath = "E:\\JAVA数据结构\\src\\BBB.mp4";
        copyFile(srcpath,destPath);

        long end = System.currentTimeMillis();
        System.out.println("AAA视频复制为BBB视频操作花费的具体时间为："+(end - start)+"ms!");
    }

}


