package Homework0130;
import java.util.Arrays;

public class homework02 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,6,4,8,10,9,15};
        int result =findUnsortedSubarray(arr);
        System.out.println(result);
    }

    private static int findUnsortedSubarray(int[] arr) {
        int[] num = Arrays.copyOf(arr,arr.length);
        Arrays.sort(num);
        System.out.println(Arrays.toString(num));

        int left=0;
        int right = num.length -1;
        while(left<num.length){
            if (num[left] != arr[left]){
                break;
            }
            left++;
        }

        if (num[left] == arr[left]){
            return 0;
        }

        while(right>=0){
            if (num[right]!= arr[right]){
                break;
            }
            right--;
        }
        return right-left+1;
    }
}





