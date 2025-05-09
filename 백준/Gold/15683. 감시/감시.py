import copy

n, m = map(int, input().split())
board = []
cctv=[]
min_val = int(1e9)

mode = [
  [], 
  [[0],[1],[2],[3]],
  [[0,2],[1,3]],
  [[0,1], [1,2], [2,3], [0,3]],
  [[0,1,2], [1,2,3], [2,3,0], [0,1,3]],
  [[0,1,2,3]]
]

dx = [1,0,-1,0]
dy = [0,1,0,-1]

for i in range(n):
  data = list(map(int, input().split())) 
  board.append(data)
  for j in range(len(data)):
    if data[j] in [1,2,3,4,5]:
      cctv.append([data[j], i, j])
      
def fill(board, mode, x, y):
  for i in mode:
    nx=x
    ny=y
    while True:
      nx += dx[i]
      ny += dy[i]
      if nx<0 or nx>=n or ny<0 or ny>=m:
        break
      if board[nx][ny]==6:
        break
      if board[nx][ny]==0:
        board[nx][ny]=-1
  return board

def dfs(board, cctv, depth):
  global min_val
  if depth == len(cctv):
    cnt=0
    for b in board:
      cnt+=b.count(0)
    min_val = min(min_val, cnt)
    return

  temp = copy.deepcopy(board)
  cctv_num, x, y = cctv[depth]
  for i in mode[cctv_num]:
    fill(temp, i, x,y)
    dfs(temp, cctv, depth+1)
    temp = copy.deepcopy(board)
  
  
dfs(board, cctv, 0)
print(min_val)