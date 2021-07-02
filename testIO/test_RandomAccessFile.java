package testIO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class test_RandomAccessFile {
    public void test(){
        RandomAccessFile randomAccessFile_1 = null;
        RandomAccessFile randomAccessFile_2 = null;
        try {
            File srcFile = new File("src\\IU.jpg");
            File destFile = new File("src\\IU2.jpg");

            randomAccessFile_1 = new RandomAccessFile(srcFile,"r");
            randomAccessFile_2 = new RandomAccessFile(destFile,"rw");

            byte[] buffer = new byte[1024];
            int len;
            while((len = randomAccessFile_1.read(buffer)) != -1){
                randomAccessFile_2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (randomAccessFile_1 != null){
                    randomAccessFile_1.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (randomAccessFile_2 != null){
                    randomAccessFile_2.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    @Test
    //指定位置插入元素
    public void test2() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("test.txt","rw");
        randomAccessFile.seek(3);//将指针调到角标为3的位置上
        randomAccessFile.write("UVW".getBytes());
        randomAccessFile.close();
    }


}
