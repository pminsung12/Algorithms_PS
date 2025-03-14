def solution(n):
    dp=[0]*(n+2)
    
    dp[0]=0
    dp[1]=1
    dp[2]=2
    for i in range(1,n-1):
        dp[i+2] = (dp[i]+dp[i+1])%1234567
    print(dp)
    return dp[n]