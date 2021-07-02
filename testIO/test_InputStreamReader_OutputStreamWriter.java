package testIO;

import org.junit.Test;

import java.io.*;

/*

 */
public class test_InputStreamReader_OutputStreamWriter {
    //异常处理还是要使用try-catch-finally语句，此处为了看清逻辑故简洁处理！
    @Test
    public void test_InputStreamReader() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src\\test.txt");
        //参数2指明了字符集，具体使用哪个字符集，取决于test.txt保存时使用的字符集。
        //InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);  此处所使用的是默认字符集
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
        char[] cbuf = new char[1024];
        int len;
        while((len = inputStreamReader.read(cbuf)) != -1){
            String str = new String(cbuf,0,len);
            System.out.println(str);
        }
        inputStreamReader.close();
    }

    @Test
    /*
    综合使用InputStreamReader和OutputStreamWriter
     */
    public void test() throws IOException {
        File file1 = new File("src\\test.txt");
        File file2 = new File("src\\test_GBK.txt"); //会出现乱码现象

        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);

        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"gbk");

        char[] cbuf = new char[20];
        int len;
        while((len = inputStreamReader.read(cbuf)) != -1){
            outputStreamWriter.write(cbuf,0,len);
        }

        inputStreamReader.close();
        outputStreamWriter.close();
    }



}
