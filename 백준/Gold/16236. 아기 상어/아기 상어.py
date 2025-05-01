from collections import deque

def bfs(a, b, size):
  visited = [[-1]*n for _ in range(n)]
  q = deque()
  q.append((a,b))
  visited[a][b]=0
  fishes=[]
  while q:
    x, y = q.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      
      if 0<=nx<n and 0<=ny<n and visited[nx][ny]==-1:
        if graph[nx][ny]<=size:
          visited[nx][ny] = visited[x][y]+1
          q.append((nx,ny))
          if 0<graph[nx][ny]<size:
            fishes.append((visited[nx][ny], nx, ny))
        
  fishes.sort()
  return fishes[0] if fishes else None

n = int(input())
graph = []
sharkX = -1
sharkY = -1
for i in range(n):
    row = list(map(int, input().split()))
    graph.append(row)
    if 9 in row:
        sharkX = i
        sharkY = row.index(9)
        graph[i][sharkY] = 0  # 상어 위치 초기화

# 상, 좌, 우, 하
dx = [-1,0,0,1]
dy = [0,-1,1,0]
size = 2
eat = 0
time =0

while True:
  target = bfs(sharkX, sharkY, size)
  if not target:
    break
  dist, nx, ny = target
  time += dist
  eat+=1
  graph[nx][ny]=0
  sharkX, sharkY = nx, ny
  if eat == size:
    size+=1
    eat=0


print(time)

  