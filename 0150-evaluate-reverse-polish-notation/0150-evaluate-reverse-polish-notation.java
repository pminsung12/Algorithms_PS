import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stk = new Stack<>();
        int n1=0,n2=0;
        for(String s: tokens){
            switch (s){
                case "+":
                    n1 = Integer.parseInt(stk.pop());
                    n2 = Integer.parseInt(stk.pop());
                    stk.push(String.valueOf(n1+n2));
                    break;
                case "-":
                    n1 = Integer.parseInt(stk.pop());
                    n2 = Integer.parseInt(stk.pop());
                    stk.push(String.valueOf(n2-n1));
                    break;
                case "*":
                    n1 = Integer.parseInt(stk.pop());
                    n2 = Integer.parseInt(stk.pop());
                    stk.push(String.valueOf(n1*n2));
                    break;
                case "/":
                    n1 = Integer.parseInt(stk.pop());
                    n2 = Integer.parseInt(stk.pop());
                    stk.push(String.valueOf(n2/n1));
                    break;
                default:
                    stk.push(s);
                    break;
            }
        }
        int answer = Integer.parseInt(stk.pop());
        return answer;
    }
}