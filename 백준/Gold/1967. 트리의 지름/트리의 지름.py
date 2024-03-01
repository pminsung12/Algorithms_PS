import sys
import heapq
input=sys.stdin.readline

sys.setrecursionlimit(10**9)

def dfs(graph, start, visited, dist):
    visited[start]=dist # 방문처리
    for d,i in graph[start]:
        if visited[i]==-1:
            dfs(graph, i, visited, dist+d)


n=int(input())
graph=[[] for _ in range(n+1)]

for i in range(n-1):
    u,v,d=map(int, input().split())
    graph[u].append((d,v))
    graph[v].append((d,u))

visited=[-1]*(n+1)
dfs(graph,1,visited,0)

furthest=visited.index(max(visited))
visited=[-1]*(n+1)
dfs(graph,furthest,visited,0)
print(max(visited))
