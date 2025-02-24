class Solution {
    public int[] sortedSquares(int[] nums) {

        int len = nums.length;
        int[] answer = new int[len];
        int l=0; 
        int r = len-1;
        int idx = len-1;
        
        while(l<=r){
            int left = Math.abs(nums[l]);
            int right = Math.abs(nums[r]);
            if(left < right){
                answer[idx]= right * right;
                r--;
            } else {
                answer[idx]= left * left;
                l++;
            }
            idx--;
        }
        return answer;
    }
    
}