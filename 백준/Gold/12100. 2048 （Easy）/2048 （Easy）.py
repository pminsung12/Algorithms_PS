import copy

def left(board):
  for i in range(n):
    cursor=0
    for j in range(1, n):
      if board[i][j]!=0:
        tmp = board[i][j]
        board[i][j] = 0
        
        if board[i][cursor]==0:
          board[i][cursor]=tmp
        elif board[i][cursor]==tmp:
          board[i][cursor]*=2
          cursor+=1
        else:
          cursor+=1
          board[i][cursor]=tmp
  return board

def right(board):
  for i in range(n):
    cursor=n-1
    for j in range(n-2, -1, -1):
      if board[i][j]!=0:
        tmp = board[i][j]
        board[i][j] = 0
        
        if board[i][cursor]==0:
          board[i][cursor]=tmp
        elif board[i][cursor]==tmp:
          board[i][cursor]*=2
          cursor-=1
        else:
          cursor-=1
          board[i][cursor]=tmp
  return board

def up(board):
  for j in range(n):
    cursor=0
    for i in range(1, n):
      if board[i][j]!=0:
        tmp = board[i][j]
        board[i][j] = 0
        
        if board[cursor][j]==0:
          board[cursor][j]=tmp
        elif board[cursor][j]==tmp:
          board[cursor][j]*=2
          cursor+=1
        else:
          cursor+=1
          board[cursor][j]=tmp
  return board

def down(board):
  for j in range(n):
    cursor=n-1
    for i in range(n-1, -1, -1):
      if board[i][j]!=0:
        tmp = board[i][j]
        board[i][j] = 0
        
        if board[cursor][j]==0:
          board[cursor][j]=tmp
        elif board[cursor][j]==tmp:
          board[cursor][j]*=2
          cursor-=1
        else:
          cursor-=1
          board[cursor][j]=tmp
  return board

def dfs(depth, board):
  global max_val
  if depth==5:
    for i in range(n):
      for j in range(n):
        if board[i][j] > max_val:
          max_val = board[i][j]
    return
  
  for i in range(4):
    copy_board = copy.deepcopy(board)
    if i==0:
      dfs(depth+1, left(copy_board))
    elif i==1:
      dfs(depth+1, right(copy_board))
    elif i==2:
      dfs(depth+1, up(copy_board))
    elif i==3:
      dfs(depth+1, down(copy_board))
  

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
max_val = 0
dfs(0, board)
print(max_val)