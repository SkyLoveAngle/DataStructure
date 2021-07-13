package ZTE_test;
/*
假设我们有一些任务列表，任务编号从1开始。不同的任务难度也不一样，分为1-5级。
我们打算把这些任务分配给牛牛，可是牛牛比较懒，每次他接受到一个任务后，
他都会从自己的todo list里找到“难度各不相同且编号和最大的五个任务”，然后再一起完成，
否则的话，牛牛就把任务放到自己的todo list，什么也不做。
请你根据输入的任务列表的情况，给出牛牛完成任务的情况。
 */
import java.util.Scanner;
import java.util.Stack;
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        Stack<Integer> stack4 = new Stack<>();
        Stack<Integer> stack5 = new Stack<>();
        int[] arr = new int[5];
        for(int i=1;i<=n;i++){
            int k = scanner.nextInt();
            if (k==1)stack1.push(i);
            if (k==2)stack2.push(i);
            if (k==3)stack3.push(i);
            if (k==4)stack4.push(i);
            if (k==5)stack5.push(i);
            if (!stack1.isEmpty() && !stack2.isEmpty()&& !stack3.isEmpty()&&
                    !stack4.isEmpty() &&!stack5.isEmpty()){
                arr[0] = stack1.pop();
                arr[1] = stack2.pop();
                arr[2] = stack3.pop();
                arr[3] = stack4.pop();
                arr[4] = stack5.pop();
                System.out.print(arr[0]+" ");
                System.out.print(arr[1]+" ");
                System.out.print(arr[2]+" ");
                System.out.print(arr[3]+" ");
                System.out.println(arr[4]);
            }else{
                System.out.println(-1);
            }
        }
    }
}
