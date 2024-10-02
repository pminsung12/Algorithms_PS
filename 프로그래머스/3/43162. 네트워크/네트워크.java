import java.util.*;
import java.io.*;

class Solution {
    
    static List<Integer>[] adjList;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        // 인접 리스트 초기화
        adjList = new ArrayList[n];
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            adjList[i] = new ArrayList<>();
        }
        
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j]==1 && computers[i][j]!=i){
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }
        
        // System.out.println(Arrays.deepToString(adjList));
        
        int answer = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i);
                answer+=1;
            }
        }
        
        return answer;
    }
    
    void dfs(int cur){
        // 1. 체크인: 방문체크
        visited[cur]=true;
        // 2. 목적지인가? -> 생략
        // 3. 연결된 곳 순회
        for(int next: adjList[cur]){
            // 4. 방문 가능한가?: 방문한 적 없다면
            if(!visited[next]){
                // 5. 방문
                dfs(next);
            }
        }
    }
}
 