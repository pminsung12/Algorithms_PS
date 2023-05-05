import sys

input=sys.stdin.readline

N=int(input())
cost=[list(map(int,input().split())) for _ in range(N)]
min_val=sys.maxsize

def dfs_backtracking(start,next, value, visited):
    global min_val
    
    if len(visited)==N:
        if cost[next][start]!=0:
            min_val=min(min_val,value+cost[next][start])
        return
    
    for i in range(N):
        if cost[next][i] != 0 and i not in visited and value<min_val:
            visited.append(i)
            dfs_backtracking(start,i,value+cost[next][i],visited)
            visited.pop()

for i in range(N):
    dfs_backtracking(i,i,0,[i])

print(min_val)
