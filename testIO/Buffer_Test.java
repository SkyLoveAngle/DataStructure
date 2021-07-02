package testIO;

import org.junit.Test;

import java.io.*;

public class Buffer_Test {
    /*
    缓冲流BufferedReader和BUfferedeWriter实现文本数据的复制
     */

    @Test
    public void testBufferedReader_BufferedWriter(){
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            //1.创建File类的对象，指明读入和写出文件
            File srcFile  = new File("src\\test.txt");
            File destFile = new File("src\\test3.txt");
            //2.创建输入输出流（两步走——先造节点流，再建缓冲流）
            FileReader fileReader = new FileReader(srcFile);
            FileWriter fileWriter = new FileWriter(destFile);

            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);
            //3.数据的读入和写出操作

            //方式一：
//            char[] buffer = new char[1024];
//            int len;
//            while((len = bufferedReader.read(buffer)) != -1){
//                bufferedWriter.write(buffer,0,len);
//            }

            //方式二：使用String
            String data;
            while((data = bufferedReader.readLine()) != null){
                bufferedWriter.write(data); //要注意data中不包含换行符，纯单行输出,要自己加换行符
                bufferedWriter.newLine();//手动加换行符
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        //4.关闭流资源（注意先后顺序！）
        //要求：先关闭外层的流，在关闭内层的流！
        try {
            if (bufferedWriter != null){
                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (bufferedReader != null){
                bufferedReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//1.创建File类的对象，指明读入和写出文件

//2.创建输入流和输出流的对象

//3.数据的读入和写出操作

//4.关闭流资源（注意先后顺序！）