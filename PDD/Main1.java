package PDD;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n<=0 || n>=19){
            System.out.println(-1);
        }

        for (int i=0;i<=n;i++){
            if (i/10==0 && (n-i)/10==0) {
                int[] arr = new int[n+1];
                for (int j = 0; j <= n+1; j++) {
                    arr[j] = 10 * i + (n - i);
                    Arrays.sort(arr);
                    for (int x = 0; x <= n+1; x++) {
                        if (arr[x] != 0)
                            System.out.println(arr[x]);
                    }
                }
            }
        }
    }
}
