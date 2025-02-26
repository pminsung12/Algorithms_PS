class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ml = Integer.MAX_VALUE;
        int len = nums.length;
        int l=0;
        int r=0;
        int sum=0;
        while(r<len){
            sum+=nums[r++];

            while(sum>=target){
                ml = Math.min(ml, r-l);
                sum-=nums[l++];
            }
        }

        return (ml==Integer.MAX_VALUE) ? 0 : ml;
        
    }
}