import java.util.*;

class Task {
    String name;
    int start;
    int left;
    
    Task(String name, int start, int left){
        this.name = name;
        this.start = start;
        this.left = left;
    }
    
}

class Solution {
    public int convertToMinute(String time){
        String[] t1 = time.split(":");
        
        return Integer.parseInt(t1[0])*60 + Integer.parseInt(t1[1]);
    }
    
    
    public String[] solution(String[][] plans) {
        LinkedList<Task> tasks = new LinkedList<>();
        for(String[] plan : plans){
            tasks.offer(new Task(plan[0], convertToMinute(plan[1]), Integer.parseInt(plan[2])));
        }
        tasks.sort((a,b)->a.start - b.start);
        
        List<String> endTasks = new ArrayList<>();
        Stack<Task> stopTasks = new Stack<>();
        
        Task now= tasks.poll();
        int time = now.start;
        while(!tasks.isEmpty()){
            time += now.left;
            Task next = tasks.peek();
            
            if(time > next.start){
                now.left = time - next.start;
                stopTasks.push(now);
            } else {
                endTasks.add(now.name);
                if(!stopTasks.empty()){
                    now = stopTasks.pop();
                    continue;
                }
            }
            now = tasks.poll();
            time = now.start;
        }
        
        endTasks.add(now.name);
        while(!stopTasks.empty()){
            endTasks.add(stopTasks.pop().name);
        }
        
        return endTasks.toArray(new String[plans.length]);
    }
}