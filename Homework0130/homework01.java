package Homework0130;
import java.util.Stack;
//逆波兰表达式
public class homework01 {
    public static void main(String[] args) {
        String[] str = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int result =evalRPN(str);
        System.out.println(result);
    }

    private static int evalRPN(String[] str) {
        Stack<Integer> stack = new Stack<>();
        for (String s : str){
            if (s.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if (s.equals("-")){
                int num1 = stack.pop();
                stack.push(-num1 + stack.pop());
            }else if (s.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if (s.equals("/")){
                int num2 = stack.pop();
                stack.push(stack.pop() / num2);
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
