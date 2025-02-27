class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int len = coins.length;

        for(int i=1; i<=amount; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int c : coins){
                if(i-c<0){
                    continue;
                }
                if(dp[i-c] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-c]+1);
                }
            }
        }

        return (dp[amount]==Integer.MAX_VALUE) ? -1 : dp[amount];
    }
}