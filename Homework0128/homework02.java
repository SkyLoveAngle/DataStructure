package Homework0128;

import java.util.Scanner;

public class homework02 {
    public static void main(String[] args) {
        System.out.println("请输入n:");
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        System.out.println(+target+"的阶乘值为："+factorial(target));
    }

    private static int factorial(int num) {
       int result=0;
            if (num == 0) {
                return 1;
            }else{
               result = num * factorial(num-1);
            }
        return result;
    }
}
