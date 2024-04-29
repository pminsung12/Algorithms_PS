import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] num = new int[10];
        for(int n:numbers){
            num[n]=1;
        }
        System.out.println(Arrays.toString(num));
        
        for(int i=0; i<num.length; i++){
            if(num[i]==0){
                answer+=i;
            }
        }
        
        return answer;
    }
}