import java.util.*;

class Solution {
    
    static int[] arr = new int[10000001];
    
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for(int i:tangerine){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        
        List<Integer> arrList = new ArrayList<>(map.values());
        Collections.sort(arrList, Collections.reverseOrder());

        int cnt=0;
        for(int i=0; i<arrList.size(); i++){
            cnt+=arrList.get(i);
            if(cnt>=k){
                answer=i+1;
                break;
            }
        }
        
        return answer;
    }
    
    
}