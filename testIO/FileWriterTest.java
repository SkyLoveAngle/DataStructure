package testIO;


import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
/*
从内存中写出数据到硬盘文件里。
1.输出操作对应的File不存在，就会自动创建此文件；如果该文件存在时
      如果使用的流构造器是FileWriter（file，true）/FileWriter（file），则是对源文件进行覆盖写入；
      如果使用的流构造器是FileWriter(file,true)，不会对原文件覆盖，而是在原文件的基础上进行添加！
 */
    @Test
    public void testFileWriter() throws IOException {
        FileWriter fileWriter = null;
        try {
            //1.提供File类对象，指明需要写出到的文件
            File file = new File("test2.txt");
            //2.提供FileWriter类的对象，用于数据的写出
            fileWriter = new FileWriter(file);
            //3.执行写出操作
            fileWriter.write("T have a dream!\n");
            fileWriter.write("我有一个梦想！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            fileWriter.close();
        }
    }
}
