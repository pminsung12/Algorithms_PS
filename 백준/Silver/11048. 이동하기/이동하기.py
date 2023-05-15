import sys
input=sys.stdin.readline

N,M=list(map(int,input().split()))
maze=[]
for i in range(N):
    maze.append(list(map(int,input().split())))

dp=[[0]*M for _ in range(N)]
dp[0][0]=maze[0][0]

for i in range(1,N):
    dp[i][0]=dp[i-1][0]+maze[i][0]

for i in range(1,M):
    dp[0][i]=dp[0][i-1]+maze[0][i]
    
for i in range(1,N):
    for j in range(1,M):
        #어차피 대각선으로 가는거보다 최댓값이면 ㄱ자나 ㄴ자로 가는게 좋음
        dp[i][j]=max(dp[i-1][j],dp[i][j-1])+maze[i][j] 

print(dp[N-1][M-1])
