package PDD;
/*
多多鸡有N个魔术盒子（编号1～N），其中编号为i的盒子里有i个球。
多多鸡让皮皮虾每次选择一个数字X（1 <= X <= N），多多鸡就会把球数量大于等于X个的盒子里的球减少X个。
通过观察，皮皮虾已经掌握了其中的奥秘，并且发现只要通过一定的操作顺序，可以用最少的次数将所有盒子里的球变没。
那么请问聪明的你，是否已经知道了应该如何操作呢？

输入描述:
第一行，有1个整数T，表示测试用例的组数。
（1 <= T <= 100）
接下来T行，每行1个整数N，表示有N个魔术盒子。
（1 <= N <= 1,000,000,000）
 
输出描述:
共T行，每行1个整数，表示要将所有盒子的球变没，最少需要进行多少次操作。

输入例子1:
3
1
2
5
 
输出例子1:
1
2
3
*/

/*
找规律：
N的值	1	2	3	4	5	6	7	8	…
最少次数	1	2	2	3	3	3	3	4	…
最少次数的值规律：2^0个1， 2^1个2， 2^2个3， 2^3个4
题目就可以转换成计算 2^0 + 2^1 + 2^2 + … + 2^j 的值大于 N 时 j 的值就行。


 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);//输入测试用例个数
        int count = input.nextInt();
        List<Integer> inputs = new ArrayList<>(count);
        for(int i=0;i<count;i++){
            inputs.add(input.nextInt());//输入盒子数量
        }
        for(Integer i:inputs){
            int sum = 0;
            int j=1;
            for(j=1;j<i;j++){
                sum+=1<<(j-1);
                if(sum>=i) break;
            }
            System.out.println(j);
        }
    }
}
