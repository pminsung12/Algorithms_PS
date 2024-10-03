class Solution {
    
    static int N;
    static int minCnt=51;
    static String target2;
    static boolean[] visited;
    static String[] input;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean isChangeable=false;
        visited = new boolean[words.length];
        target2 = target;
        input = words;
        
        for(String s: words){
            // System.out.println(s);
            if(s.equals(target)){
                // System.out.println("true");

                isChangeable = true;
            }
        }
        
        if(!isChangeable){
            answer = 0;
        } else {
            for(int i=0; i<words.length; i++){
                if(change(words[i], begin)){
                    // visited[i]=true;
                    dfs(i, 1);
                    // visited[i]=false;
                }
            }
            answer = minCnt;
        }
        return answer;
    }
    
    void dfs(int cur, int cnt){
        // 1. 체크인
        visited[cur]=true;
        // 2. 목적지인가
        // System.out.println(input[cur]);

        if(input[cur].equals(target2)){
            minCnt = Math.min(minCnt, cnt);
        } else{
            // 3. 연결된 곳을 순회: words 배열을 순회
            for(int i=0; i<input.length; i++){
                // 4. 방문할 수 있으면: 방문한 적이 없고, 알파벳 한 개만 차이나면
                if(!visited[i] && change(input[i], input[cur])){
                    // 5. 방문
                    dfs(i, cnt+1);
                }
            }
        }
        visited[cur]=false;
    }
    
    boolean change(String a, String b){
        int cnt=0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)!=b.charAt(i)){
                cnt++;
            }
        }
        if(cnt==1){
            return true;
        }
        return false;
    }
}