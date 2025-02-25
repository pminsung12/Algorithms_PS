class Solution {
    public int longestMountain(int[] arr) {

        int maxLen = 0;
        int len = 1;
        boolean down = false;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i]<arr[i+1]){
                if(down){
                    down = false;
                    len=1;
                }
                len+=1;
            } else if(arr[i] > arr[i+1]){
                down = true;
                if(len!=1){
                    len+=1;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;
        
    }
}