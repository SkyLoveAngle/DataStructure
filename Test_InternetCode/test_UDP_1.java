package Test_InternetCode;

import org.junit.Test;
import java.io.IOException;
import java.net.*;

public class test_UDP_1 {
    //发送端
    @Test
    public void sender() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        String string = "这是以UDP方式发送的数据！！！";
        byte[] data = string.getBytes();
        InetAddress inetAddress = InetAddress.getLocalHost();
        //下面一行代码相当于封装了一个数据报~~
        DatagramPacket datagramPacket = new DatagramPacket(data,0,data.length,inetAddress,9090);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }

    //接收端
    @Test
    public void receiver() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9090);
        byte[] buffer = new byte[100];
        DatagramPacket datagramPacket = new DatagramPacket(buffer,0,buffer.length);
        datagramSocket.receive(datagramPacket);
        System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));
        datagramSocket.close();
    }
}
