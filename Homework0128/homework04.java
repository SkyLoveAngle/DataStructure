package Homework0128;

public class homework04 {
    public static void main(String[] args) {
        String str = new String("AbcDdCBa");
        boolean result= isPalindrome(str);
        System.out.println(result);
    }

    private static boolean isPalindrome(String str) {
        StringBuffer newStr = new StringBuffer();
        int len=str.length();
        for (int i=0;i<len;i++){
            char ch = str.charAt(i);
            if (Character.isLetterOrDigit(ch)){
                newStr.append(Character.toLowerCase(ch));
            }
        }

        int left=0;
        int right=newStr.length()-1;
        while(left<right){
            if (newStr.charAt(left) != newStr.charAt(right)){
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
