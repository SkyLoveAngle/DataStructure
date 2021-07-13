package ZTE_test;
/*
牛牛有一条长度为n的绳子。
第一天，绳子的长度为n。
第二天，这条绳子会被切成两段长度分别为n/2,n-n/2;
第三天，对于第二天切出来的每段长度大于1的绳子，设其长度为m，牛牛又会将其切成m/2,m-m/2;
如此反复切下去... ...
但是，牛牛知道，终有一天所有的绳子都会被切成长度为1的绳子，到时候他就没有绳子可切了。
所有绳子都变成长度为1的绳子是第几天？

注：n/2表示n除以2向下取整。
 */

import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }

        for (int i=0;i<n;i++){
            run(arr[i]);
        }
    }

    public static void run(int n) {
        int count =1;
        if (n==1) {
            System.out.println(count);
        }else{
            while(n!=1){
                if (n%2 == 0){
                    n=n/2;
                    count++;
                }else{
                    n=n/2+1;
                    count++;
                }
            }
            System.out.println(count);
        }
    }

}
