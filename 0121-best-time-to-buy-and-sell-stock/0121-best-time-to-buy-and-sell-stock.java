class Solution {
    public int maxProfit(int[] prices) {
        int maxP =0;
        int l=0;
        int r=1;
        int len = prices.length;
        while(r!=len){
            if(prices[l]<prices[r]){
                int profit = prices[r]-prices[l];
                maxP = Math.max(maxP, profit);
            } else {
                l=r;
            }
            r++;
        }

        return maxP;
        
    }
}