import sys
input = sys.stdin.readline

N = int(input())

dp = [0]*31
dp[2] = 3

if N % 2:
    print(0)
else:
    for i in range(4, N+1, 2):
        if i % 2 == 0:
            dp[i] = dp[i-2]*3 + sum(dp[:i-2])*2+2
        else:
            dp[i] = 0

    print(dp[N])
