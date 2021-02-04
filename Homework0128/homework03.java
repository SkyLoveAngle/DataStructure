package Homework0128;

import java.util.Scanner;

public class homework03 {
    public static void main(String[] args) {
        System.out.println("请输入n:");
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        System.out.println("1-"+target+"之间的整数相加和为："+add(target));
    }

    private static int add(int num) {
        int sum=0;
        if (num==0) {
            return 0;
        }else{
            sum=num+add(num-1);
            return sum;
        }
    }
}
