class Solution {
    public int solution(int n) {
        int answer = 0;
        int start=0, end=0;
        int sum=0;
        while(start<=n){
            if(sum<n){
                end++;
                sum+=end;
            } else if(sum==n){
                answer++;
                end++;
                sum+=end;
            } else {
                sum-=start;
                start++;
            }
        }
        return answer;
    }
}