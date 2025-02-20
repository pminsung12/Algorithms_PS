class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int len = nums.length;
        int[] answer = new int[len];

        for(int i=0; i<len; i++){
            int cnt=0;
            for(int j=0; j<len; j++){
                if(i!=j && nums[i]>nums[j]){
                    cnt++;
                }
            }
            answer[i]=cnt;
        }
        
        return answer;
    }
}