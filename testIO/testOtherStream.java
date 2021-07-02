package testIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
标准的输入流，输出流：System.in(从键盘输入)  /System.out(默认从控制台输出)
打印流
数据流
 */
public class testOtherStream {
    /*
    从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作！
    直至当输入“e”或者“exit”时，退出程序！
     */
        public static void main (String[]args){
            //使用System.in实现。System.in--->转换流--->使用BufferedReader的readLine()方法
            BufferedReader bufferedReader = null;
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    System.out.println("请输入字符串：");
                    String data = bufferedReader.readLine();
                    if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                        System.out.println("程序结束！");
                        break;
                    }
                    String upperCase = data.toUpperCase();
                    System.out.println(upperCase);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
}


