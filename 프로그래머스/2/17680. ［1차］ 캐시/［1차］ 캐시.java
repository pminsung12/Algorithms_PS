import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        List<String> lst = new ArrayList<>();
        
        if(cacheSize==0){
            return cities.length*5;
        }
        for(String s: cities){
            // 대소구분 x
            String upper = s.toUpperCase();
            if(lst.remove(upper)){
                // cache hit
                answer++;
                lst.add(upper);
            } else {
                // cache miss
                answer+=5;
                if(lst.size()==cacheSize){
                    lst.remove(0);
                }
                lst.add(upper);
            }
        }
        
        return answer;
    }
}