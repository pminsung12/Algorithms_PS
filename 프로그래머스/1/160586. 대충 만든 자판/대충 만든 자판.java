import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> dict=new HashMap<>();
        
        for(int i=0; i<keymap.length; i++){
            for(int j=0; j<keymap[i].length(); j++){
                char k=keymap[i].charAt(j);
                if(dict.containsKey(k)){
                    dict.put(k, Math.min(j+1, dict.get(k)));
                } else{
                    dict.put(k, j+1);
                }
            }
        }
        
        for(int i=0; i<targets.length; i++){
            int cnt=0;
            boolean isTypable=true;
            for(int j=0; j<targets[i].length(); j++){
                char c=targets[i].charAt(j);
                if(dict.containsKey(c)){
                    cnt+=dict.get(c);
                } else{
                    isTypable=false;
                }
            }
            if(isTypable)
                answer[i]=cnt;
            else
                answer[i]=-1;
        }
        return answer;
    }
}