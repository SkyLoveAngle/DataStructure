package Test_InternetCode;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class test_TCP_1 {
    //客户端
    @Test
    public void client(){
        Socket socket = null;//socket封装了IP地址和端口
        OutputStream outputStream = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress,6899);
            outputStream = socket.getOutputStream();
            outputStream.write("你好！我是客户端！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null){
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //服务器端
    @Test
    public void server(){
        Socket socket = null;
        ServerSocket serverSocket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            serverSocket = new ServerSocket(6899);
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();

            //不建议下面的操作，因为会导致乱码
//            byte[] buffer = new byte[20];
//            int len;
//            while((len = inputStream.read(buffer)) != -1){
//                String string = new String(buffer,0,len);
//                System.out.println(string);
//            }

            //建议操作
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while((len = inputStream.read(buffer)) != -1){
                byteArrayOutputStream.write(buffer,0,len);
            }
            System.out.println(byteArrayOutputStream.toString());
            System.out.println("收到了来自于："+socket.getInetAddress().getHostName()+"的问候！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (byteArrayOutputStream != null){
                    byteArrayOutputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (inputStream != null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null){
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (serverSocket != null){
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
