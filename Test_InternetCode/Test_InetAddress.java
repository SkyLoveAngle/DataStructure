package Test_InternetCode;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test_InetAddress {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress_1 =  InetAddress.getByName("192.168.10.14");
            System.out.println(inetAddress_1);
            //我们也可以由 域名 获取 IP
            InetAddress inetAddress_2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress_2);
            //获取本机IP地址
            InetAddress inetAddress_3 = InetAddress.getLocalHost();
            System.out.println(inetAddress_3);//我们发现结果不是170.0.0.1，是因为我们在局域网内~~

            //实例化InetAddress的两个方法：
            //获取域名,getHostName()
            System.out.println(inetAddress_2.getHostName());
            //获取IP地址
            System.out.println(inetAddress_2.getAddress());



        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
