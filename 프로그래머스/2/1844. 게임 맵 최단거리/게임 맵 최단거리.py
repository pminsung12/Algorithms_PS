from collections import deque

dx=[0,1,0,-1]
dy=[1,0,-1,0]

def bfs(maps, visited, n, m, dist):
    visited[0][0]=True
    q=deque()
    q.append((0,0))
    while len(q)>0:
        x,y=q.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if(nx<0 or nx >= n or ny<0 or ny>=m):
                continue
            if(maps[nx][ny]==0):
                continue
            if(visited[nx][ny]==True):
                continue
            q.append((nx,ny))
            visited[nx][ny]=True
            dist[nx][ny]=dist[x][y]+1


def solution(maps):
    answer = 0
    n=len(maps)
    m=len(maps[0])
    visited=[[False]*m for _ in range(n)]
    dist=[[0]*m for _ in range(n)]
    
    bfs(maps, visited, n, m, dist)
    for i in range(n):
        for j in range(m):
            print(dist[i][j], ' ', end="")
        print()
    return dist[n-1][m-1]+1 if dist[n-1][m-1]>0 else -1
