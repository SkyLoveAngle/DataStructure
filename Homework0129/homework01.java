package Homework0129;

import java.util.Scanner;

public class homework01 {
    public static void main(String[] args) {
        System.out.println("请输入n:");
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        System.out.println("第"+target+"项的斐波那切值为："+factorial(target));
    }

    private static int factorial(int num) {
        if (num <= 0) {
            System.out.println("请输入一个正整数！");
        } else if (num == 1 || num == 2) {
            return 1;
        }
            return factorial(num - 1) + factorial(num - 2);
    }
}
