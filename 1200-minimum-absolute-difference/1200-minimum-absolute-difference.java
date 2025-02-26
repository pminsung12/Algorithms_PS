import java.util.*;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(arr);
        int mad=Integer.MAX_VALUE;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i+1]-arr[i]<mad){
                mad = arr[i+1]-arr[i];
                answer = new ArrayList<>();
                answer.add(Arrays.asList(arr[i], arr[i+1]));

            } else if(arr[i+1]-arr[i]==mad){
                answer.add(Arrays.asList(arr[i], arr[i+1]));
            } else {
                continue;
            }
        }
        return answer;
        
    }
}