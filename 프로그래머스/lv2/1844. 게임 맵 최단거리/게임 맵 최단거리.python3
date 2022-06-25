from collections import deque
dx=[0,0,-1,1]
dy=[1,-1,0,0]
def bfs(maps,n,m):
    dist=list([0 for _  in range(m)] for _ in range(n))
    q=deque()
    q.append((0,0))
    #dist[0][0]=1
    while q:
        x,y=q.popleft()
        for i in range(4):
            nx,ny=x+dx[i],y+dy[i]
            
            if(nx<0 or nx>=n or ny<0 or ny>=m or not maps[nx][ny]):
                continue
            if maps[nx][ny]==1:
                q.append((nx,ny))
                maps[nx][ny]=maps[x][y]+1
                print(f"maps[{nx}][{ny}]={maps[nx][ny]}")
    print(maps[n-1][m-1])
    return maps[n-1][m-1] if maps[n-1][m-1]!=1 else -1

def solution(maps):
    answer = 0
    answer=bfs(maps,len(maps),len(maps[0]))
    return answer