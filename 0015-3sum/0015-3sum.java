import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();        
        Arrays.sort(nums);
        // 1. 투 포인터를 n번 돌리기
        // n^3 -> n^2
        int target =0;
        for(int i=0; i<nums.length-2; i++){
            target = 0 - nums[i];

            // 2. 투 포인터
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                if(nums[l]+nums[r]==target){
                    set.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    r--;
                } else if(nums[l]+nums[r] < target){
                    l++;
                } else {
                    r--;
                }
            }
        }

        List<List<Integer>> answer = new ArrayList<>(set);
        return answer;
    }
}