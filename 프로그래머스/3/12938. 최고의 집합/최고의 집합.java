class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if(n>s){
            return new int[]{-1};
        }
        
        int base = s/n;
        int rem = s%n;
        
        for(int i=0; i<n; i++){
            if(i<n-rem){
                answer[i] = base;
            } else {
                answer[i] = base+1;
            }
        }
        
        return answer;
    }
}