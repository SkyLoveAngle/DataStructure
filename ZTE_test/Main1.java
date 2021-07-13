package ZTE_test;
/*
在新的一年，牛牛想跳得更高。
牛牛本身可以跳高h米。同时牛牛有n颗跳高弹，使用第i颗跳高弹可以使牛牛跳高高度增加ai米，
且跳高弹的效果是可以叠加的，也就是说如果牛牛使用多颗跳高弹，
那么他的跳高高度将会增加这些跳高弹单个效果的和。每颗跳高弹只能使用一次。
请问牛牛最少需要使用多少个跳高弹，才能让牛牛的高度至少是{u}u米高呢？数据保证答案存在。
 */
import java.util.Arrays;
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int h = scanner.nextInt();
        int u = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int count=0;
        int sum=h;
        int i=n-1;
        Arrays.sort(arr);//降序排列
        if (sum >= u){
            System.out.println(count);
            return;
        }else{
            for (int j=n-1;j>=0;j--){
                sum += arr[j];
                count++;
                if (sum >= u){
                    System.out.println(count);
                    break;
                }
            }
        }
    }
}