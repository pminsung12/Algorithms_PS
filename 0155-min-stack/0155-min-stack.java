import java.util.*;

class MinStack {
    
    Stack<Integer> stk, min;


    public MinStack() {
        stk = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if(min.empty()) min.push(val);
        else if(min.peek() >= val) min.push(val);
        return;
    }
    
    public void pop() {
        int tmp = stk.pop();
        if(!min.empty() && tmp == min.peek()){
            min.pop();
        }
        return;
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */