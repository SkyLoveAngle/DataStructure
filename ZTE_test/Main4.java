package ZTE_test;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/*
在一个超市里有两个收银台，现在它们面前排了长长的队伍。
第一个收银台前排了n1个人，从靠近收银台开始分别编号1,2,...,n1;
第二个收银台前排了n2个人，从靠近收银台开始分别编号n1+1,n1+2,...,n1+n2;
可是总有一些人觉的自己的队伍排的太慢了，会从自己的队伍里离开，然后排在另一个队伍的最后。
那当所有的人都换完队伍后，这两个队伍的编号最后是什么样的呢？
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int q = scanner.nextInt();//q表示离开队伍的编号
        int arr[] = new int[q];
        for (int i = 0; i < q; i++) {
            arr[i] = scanner.nextInt();
        }

        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();
        for (int i = 1; i <= n1; i++) {
            set1.add(i);
        }
        for (int i = n1 + 1; i <= n1 + n2; i++) {
            set2.add(i);
        }

        for (int i = 0; i < q; i++) {
            if (set1.contains(arr[i])) {
                set1.remove(arr[i]);
                set2.add(arr[i]);
            } else {
                if (set2.contains(arr[i])) {
                    set2.remove(arr[i]);
                    set1.add(arr[i]);
                }
            }
        }

        for (Integer x:set1){
            System.out.print(x+" ");
        }
        System.out.println();
        for (Integer x :set2){
            System.out.print(x+" ");
        }

    }
}
