package ZTE_test;

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a-b <= 0 || a-b > k){
            System.out.println(-1);
        }
        while(a-b <= k){
            if (k % (a-b) == 0){
                System.out.println(k / (a-b));
            }
            if ((k-a)/(a-b) == 0){
                System.out.println(k/(a-b) + 1);
            }
            if (a%k <k){
                System.out.println(2);
            }
        }
        System.out.println(-1);
    }
}
