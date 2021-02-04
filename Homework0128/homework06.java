package Homework0128;
import java.util.Scanner;

public class homework06 {
    private static String name = "sky";
    private static String password = "123456";

    public static void main(String[] args) throws PasswordException, NameException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名: ");
        String Username = scanner.next();
        System.out.println("请输入密码: ");
        String Userpassword = scanner.next();
        if (!Username.equals(name)) {
            throw new NameException("用户名错误");
        }
        if (!Userpassword.equals(password)) {
            throw new PasswordException("密码错误");
        }
        System.out.println("登陆成功!");
    }

    private static class PasswordException extends Exception {
        public PasswordException(Object 密码错误) {
        }
    }

    private static class NameException extends Exception {
        public NameException(Object 用户名错误) {
        }
    }
}



