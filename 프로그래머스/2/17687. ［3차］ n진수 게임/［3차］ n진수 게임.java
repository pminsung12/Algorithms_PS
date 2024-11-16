import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder convertAll = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; convertAll.length()<=t*m; i++){
            convertAll.append(Integer.toString(i, n));
        }
        
        for(int i=p-1; answer.length()<t; i+=m){
            answer.append(convertAll.charAt(i));
        }
        
        return answer.toString().toUpperCase();
    }
}