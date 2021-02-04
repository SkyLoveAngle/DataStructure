package Homework0128;

import java.util.Scanner;

public class homework07 {
    public static void main(String[] args) {
        System.out.println("请输入n:");
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        System.out.println("组成"+target+"的各个整数相加和为："+sum(target));
    }

    private static int sum(int num) {
        if (num<9){
            return num;
        }else{
            return (num%10)+sum(num/10);
        }
    }
}
