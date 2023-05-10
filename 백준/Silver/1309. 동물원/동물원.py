import sys
input=sys.stdin.readline

N=int(input())
dp=[0,0]*N
dp[0]=[1,2] # 1은 빈거(곱하기 3할 것) 2는 하나 채워진 것(곱하기 2할 것)
for i in range(1,N):
    dp[i]= [(dp[i-1][0]+dp[i-1][1]) % 9901, (dp[i-1][0]*2+dp[i-1][1])% 9901]

# print(dp)
print((dp[N-1][0] + dp[N-1][1])%9901)