package Homework0203;

public class homework01 {
    public static void main(String[] args) {
        int[] arr= new int[]{3,3,6,5,-2,2,5,1,-9,4};
        boolean result=  canThreePartsEqualSum(arr);
        System.out.println(result);
    }

    private static boolean canThreePartsEqualSum(int[] arr) {
        int sum=0;
        for (int num:arr){
            sum+=num;
        }
        if (sum%3!=0){
            return false;
        }
        int target=sum/3;
        int n=arr.length;
        int i=0,cur=0;
        while(i<n){
            cur+=arr[i];
            if (cur==target){
                break;
            }
            i=i+1;
        }
        if (target!=cur){
            return false;
        }
        int j=i+1;
        while (j+1<n){
            cur+=arr[j];
            if (cur==2*target){
                return true;
            }
            j=j+1;
        }
        return false;
    }
}
