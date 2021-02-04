package Homework0128;

import java.util.Arrays;

public class homework05 {
    public static void main(String[] args) {
        char[] arr = new char[]{'a','a','b','b','b','c','c','c','c'};
        int size = compress(arr);
        System.out.println(size);
    }

    private static int compress(char[] arr) {
        int left=0;
        int size=0;
        for (int right =0;right<=arr.length;right++){
            if (right ==arr.length || arr[right]!=arr[left] ){
                arr[size]=arr[left];
                size++;
                if (right-left>1) {
                    for (char c : String.valueOf(right - left).toCharArray()) {
                        arr[size] = c;
                        size++;
                    }
                }
                left=right;
            }
        }
        System.out.println(Arrays.toString(arr));
        return size;
    }
}




