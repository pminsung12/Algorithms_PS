import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> s = new HashSet<>();
        
        int[] arr = new int[elements.length * 2];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = elements[i % elements.length];
        }
        for(int i=0; i<elements.length; i++){
            for(int j=1; j<=elements.length; j++){
                int sum=0;
                for(int k=0; k<j; k++){
                    sum+=arr[i+k];
                }
                s.add(sum);
            }
        }
        
        return s.size();
    }
}