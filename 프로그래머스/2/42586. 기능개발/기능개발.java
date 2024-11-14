import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int[] works = new int[progresses.length];

        for(int i=0; i<progresses.length; i++){
            works[i] = (int) (100-progresses[i]) / speeds[i];
            if((100-progresses[i]) % speeds[i]!=0){
                works[i]++;
            }
        }

        int prev=works[0];
        int cnt=1;
        for(int i=1; i<progresses.length; i++){
            if(works[i]>prev){
                answer.add(cnt);
                cnt=1;
                prev=works[i];
            }else{
                cnt++;
            }
        }
        answer.add(cnt);
        
        int[] answerArr = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            answerArr[i] = answer.get(i);
        }
        
        return answerArr;
    }
}