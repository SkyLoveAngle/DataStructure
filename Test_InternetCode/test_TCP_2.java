package Test_InternetCode;

import org.junit.Test;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class test_TCP_2 {
    //客户端
    @Test
    public void client(){
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
            outputStream = socket.getOutputStream();
            fileInputStream = new FileInputStream(new File("src\\IU.jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while((len = fileInputStream.read(buffer)) != -1){
                outputStream.write(buffer,0,len);
            }
            socket.shutdownOutput();//关闭数据传输
            //客户端接受来自服务器端的数据并显示到控制台~~
            InputStream inputStream = socket.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer1 = new byte[5];
            int len1;
            while((len1 = inputStream.read(buffer1)) != -1){
                byteArrayOutputStream.write(buffer1,0,len1);
            }
            System.out.println(byteArrayOutputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null){
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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
            try {
                if (byteArrayOutputStream != null){
                    byteArrayOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //服务端
    @Test
    public void server(){
        Socket socket = null;
        ServerSocket serverSocket = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        OutputStream outputStream = null;
        try {
            serverSocket = new ServerSocket(9090);
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            fileOutputStream = new FileOutputStream(new File("IUIU.jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while((len = inputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }
            //服务器端给客户端反馈~~
            outputStream = socket.getOutputStream();
            outputStream.write("你好，客户端！文件已收到！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null){
                    fileOutputStream.close();
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
            try {
                if (outputStream != null){
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
