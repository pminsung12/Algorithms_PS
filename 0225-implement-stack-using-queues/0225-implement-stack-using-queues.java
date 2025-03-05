import java.util.*;

class MyStack {
    public ArrayDeque<Integer> q1;

    public MyStack() {
        q1 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        q1.addLast(x);
        for(int i=1; i<q1.size(); i++){
            q1.addLast(q1.removeFirst());
        }
    }
    
    public int pop() {
        return q1.removeFirst();
    }
    
    public int top() {
        return q1.peekFirst();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */