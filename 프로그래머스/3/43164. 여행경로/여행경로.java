import java.util.*;
import java.io.*;

class Solution {
    
    static String[][] tickets2;
    static List<String> routes;
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        routes = new ArrayList<>();
        tickets2 = tickets;
                
        ArrayDeque<String> q = new ArrayDeque<>();
        visited = new boolean[tickets.length];
        
        dfs("ICN", "ICN", 0);
        
        Collections.sort(routes);
        return routes.get(0).split(" ");
    }
    
    void dfs(String cur, String route, int cnt){
        // 목적지인가?: 모든 티켓을 돌았을 때
        if(cnt == tickets2.length){
            routes.add(route);
            return;
        } 
        // 연결된 곳 순회
        for(int i=0; i<tickets2.length; i++){
            // 방문 가능한가?: 방문한 적이 없고 cur이 출발 공항일 때
            if(!visited[i] && cur.equals(tickets2[i][0])){
                // 체크인
                visited[i]=true;
                // dfs
                dfs(tickets2[i][1], route + " " + tickets2[i][1], cnt+1);
                // 원복
                visited[i]=false;
            }
        }
    }
}