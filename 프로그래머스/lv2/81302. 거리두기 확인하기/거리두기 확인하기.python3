from collections import deque

dx=[0,0,-1,1]
dy=[1,-1,0,0]

def bfs(graph):
    start=[]
    for i in range(5):
        for j in range(5):
            if graph[i][j]=='P':
                start.append([i,j])
    
    for s in start:
        queue=deque([s])
        #방문처리
        visited=[[0 for _ in range(5)] for _ in range(5)]
        #길이처리
        dist=[[0 for _ in range(5)] for _ in range(5)]
        visited[s[0]][s[1]]=1
    
        while queue:
            x,y=queue.popleft()

            for i in range(4):
                nx=x+dx[i]
                ny=y+dy[i]

                if nx>4 or ny>4 or nx<0 or ny<0 or visited[nx][ny]:
                    continue

                if graph[nx][ny]=='O':
                    visited[nx][ny]=1
                    dist[nx][ny]=dist[x][y]+1;
                    queue.append([nx,ny])
                elif graph[nx][ny]=='P':
                    if dist[x][y]<=1:
                        return 0
    return 1

def solution(places):
    answer = []
    for i in places:
        answer.append(bfs(i))
        
#         comprehension failed
#         graph.append(list(j) for j in i)
    
    return answer