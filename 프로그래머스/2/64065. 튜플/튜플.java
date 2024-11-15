import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int[] answer = {};
        Map<Integer, Integer> cMap  = new HashMap<>();
        
        s = s.replace("}", "");
        s = s.replace("{", "");
        String[] sArr = s.split(",");
        
        for(String i: sArr){
            cMap.put(Integer.parseInt(i),cMap.getOrDefault(Integer.parseInt(i),0)+1);
        }
        
        List<Integer> lst = new ArrayList<>(cMap.keySet());
        
        Collections.sort(lst, (a,b) -> cMap.get(b).compareTo(cMap.get(a)));
        answer = new int[cMap.size()];
        for(int i=0; i<cMap.size(); i++){
            answer[i]=lst.get(i);
        }
        
        return answer;
    }
}