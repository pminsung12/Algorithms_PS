import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        Map<String, Integer> xMap = new HashMap<>();
        Map<String, Integer> yMap = new HashMap<>();

        List<String> list = new ArrayList<>();
        
        for(String key: X.split("")){
            xMap.put(key, xMap.getOrDefault(key, 0)+1);
        }
        
        for(String key: Y.split("")){
            yMap.put(key, yMap.getOrDefault(key, 0)+1);
        }
        
        for(String key: xMap.keySet()){
            if(!yMap.containsKey(key)) continue;
            
            for(int i=0; i<Math.min(xMap.get(key), yMap.get(key)); i++){
                list.add(key);
            }
        }
        
        for(String s: list){
            answer.append(s);
        }
        answer.reverse();
        
        if(answer.length()==0) return "-1";
        if(answer.toString().replaceAll("0", "").isEmpty()) return "0";
        return answer.toString();
    }
}