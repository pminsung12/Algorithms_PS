from collections import deque

def bfs(rx, ry, bx, by):
  q = deque()
  q.append((rx, ry, bx, by))
  visited = []
  visited.append((rx, ry, bx, by))
  count=0
  while q:
    for _ in range(len(q)):
      rx, ry, bx, by = q.popleft()
      
      if count>10:
        print(-1)
        return
      
      if board[rx][ry]=='O':
        print(count)
        return
      
      for i in range(4):
        nrx, nry = rx, ry
        while True:
          nrx += dx[i]
          nry += dy[i]
          if board[nrx][nry]=='#':
            nrx-=dx[i]
            nry-=dy[i]
            break
          if board[nrx][nry]=='O':
            break
        nbx, nby = bx, by
        while True:
          nbx += dx[i]
          nby += dy[i]
          if board[nbx][nby]=='#':
            nbx-=dx[i]
            nby-=dy[i]
            break
          if board[nbx][nby]=='O':
            break
        
        if board[nbx][nby]=='O':
          continue
        if nrx==nbx and nry==nby:
          if abs(nrx-rx)+abs(nry-ry) > abs(nbx-bx)+abs(nby-by):
            nrx -= dx[i]
            nry -= dy[i]
          else:
            nbx-=dx[i]
            nby-=dy[i]
        if (nrx, nry, nbx, nby) not in visited:
          q.append((nrx, nry, nbx, nby))
          visited.append((nrx, nry, nbx, nby))
          
    count+=1
  print(-1)
      
  


n, m = map(int, input().split())
board = [ ]
for i in  range(n):
    board.append(list(input()))
    for j in range(m):
        if board[i][j] == 'R': # 빨간구슬 위치
            rx, ry = i, j
        elif board[i][j] == 'B': # 파란구슬 위치
            bx, by = i, j
    
dx = [-1,0,1,0]
dy = [0,1,0,-1]

bfs(rx, ry, bx, by)