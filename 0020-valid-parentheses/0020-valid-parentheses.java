import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for(char c: s.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                stk.push(c);
                continue;
            }
            if(stk.size()==0 || map.get(c)!=stk.pop()){
                return false;
            }
        }

        return (stk.empty()) ? true : false;
    }
}