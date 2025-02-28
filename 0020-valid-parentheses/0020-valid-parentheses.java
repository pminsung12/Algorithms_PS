import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(stk.empty()){
                stk.push(c);
                continue;
            }
            char top = stk.peek();
            if(c==')' && top=='('){
                stk.pop();
            } else if(c=='}' && top=='{'){
                stk.pop();
            } else if(c==']' && top=='['){
                stk.pop();
            } else {
                stk.add(s.charAt(i));
            }
        }
        return (stk.empty()) ? true : false;
    }
}