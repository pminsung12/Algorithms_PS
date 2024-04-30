import java.util.*;

class Solution {
    public List<Integer> solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> answer = new ArrayList<>(photo.length);
        Map<String, Integer> score = new HashMap<>();
        
        for(int i=0; i<name.length; i++){
            score.put(name[i], yearning[i]);
        }
        
        for(String[] p:photo){
            int cnt=0;
            for(String s: p){
                if(score.containsKey(s)){
                    cnt+=score.get(s);
                }
            }
            answer.add(cnt);
        }
        
        return answer;
    }
}