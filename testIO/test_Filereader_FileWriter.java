package testIO;

import org.junit.Test;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/*
这个操作就是实现了两个文件之间的复制！
 */
public class test_Filereader_FileWriter {
    @Test
    public void testFileReaderFileWriter()  {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            //1.创建File类的对象，指明读入和写出文件
            File srcFile = new File("src\\test.txt");
            File destFile = new File("E:\\JAVA数据结构\\test2.txt");

            //不能使用字符流来处理图片等字节数据
//            File srcFile = new File("src\\IU.jpg");
//            File destFile = new File("src\\IU1.jpg");

            //2.创建输入流和输出流的对象
            fileReader = new FileReader(srcFile);
            fileWriter = new FileWriter(destFile);
            //3.数据的读入和写出操作
            char[] cbuf = new char[5];
            int len; //记录每次读入到cbuf数组中的字符的个数
            while((len = fileReader.read(cbuf)) != -1){
                //每次写出len个字符
                fileWriter.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.关闭流资源（注意先后顺序！）
                if (fileWriter != null){
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (fileReader != null){
                        fileReader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
