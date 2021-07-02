package testIO;

import org.junit.Test;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderWriterTest {
    //为了保证流资源一定可以执行关闭操作，此处异常处理一定要使用try-catch-finally！
    @Test
    public void testFileReader1() throws IOException {
        FileReader fileReader = null;
        try {
            //1.实例化file类的对象，指明要操作的文件
            File file = new File("src\\test.txt");
            //2.提供数据流
            fileReader = new FileReader(file);
            //3.数据的读入。read();
            // 返回读入的一个字符，如果到达文件末尾，返回-1。
            int data = fileReader.read();
            while(data != -1){
                System.out.println((char)data);
                data = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭操作
            try {
                fileReader.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }


    @Test
    public void testFileReader2() throws IOException {
        FileReader fileReader = null;
        try {
            //1.实例化file类的对象，指明要操作的文件
            File file = new File("src\\test.txt");
            //2.提供数据流
            fileReader = new FileReader(file);
            //3.数据的读入。read(char[] cbuf);
            // 返回读入到char[] cubf 数组中的字符的个数，如果到达文件末尾，返回-1。
            char[] cbuf = new char[5];
            int len; //用来判断是否读到文件末尾了。
            while( (len = fileReader.read(cbuf))!= -1){
               for (int i=0;i<len;i++){
                   System.out.print(cbuf[i]);
               }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                //4.流的关闭操作
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
