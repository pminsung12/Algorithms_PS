class Solution {
    
    static int[] maxPlayers;
    
    public void updateMaxPlayers(int idx, int m, int k){
        for(int i=0; i<k; i++){
            if(idx+i>=maxPlayers.length){
                break;
            }
            maxPlayers[idx+i]+=m;  
        }
        return;
    }
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int len = players.length;
        maxPlayers = new int[len];
        for(int i=0; i<len; i++){
            maxPlayers[i] = m;
        }
        
        for(int p=0; p<len; p++){
            while(players[p]>=maxPlayers[p]){
                updateMaxPlayers(p, m, k);
                answer++;
            }
        }
    
        return answer;
    }
}