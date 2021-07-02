package testIO;

import org.junit.Test;

import java.io.*;

public class test_DataInputStream_DataOutputStream {
    //异常处理还是要使用try-catch-finally语句，此处为了看清逻辑故简洁处理！
    @Test
    //将内存中的基本数据类型变量和字符串写入到文件中
    public void test1() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("src//test.txt");
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

        dataOutputStream.writeUTF("HAHA!Welcom!");
        dataOutputStream.flush();//刷新操作
        dataOutputStream.writeInt(20);
        dataOutputStream.flush();
        dataOutputStream.writeBoolean(true);
        dataOutputStream.flush();

        dataOutputStream.close();
    }

    @Test
    //将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中！
    public void test2() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src\\test.txt");
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        //读取的顺序一定要和写入的顺序要一致对应，否则报错！
        String name = dataInputStream.readUTF();
        int age = dataInputStream.readInt();
        boolean isMale = dataInputStream.readBoolean();
        System.out.println("name:  "+ name);
        System.out.println("age:   "+ age);
        System.out.println("isMale:"+ isMale);

        dataInputStream.close();
    }
}
