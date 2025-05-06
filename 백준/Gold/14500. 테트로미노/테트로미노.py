n, m = map(int, input().split())
maxScore = 0

def calcByShape(i,j, shapes):
  global maxScore
  for shape in shapes:
    score=0
    flag =0
    for s in shape:
      x = i + s[0] 
      y = j + s[1]
      if 0<=x<=n-1 and 0<=y<=m-1:
        score += board[x][y]
      else:
        flag=1
        break
    if flag:
      continue
    maxScore = max(maxScore, score)
  return
        

board = [list(map(int, input().split())) for _ in range(n)]

shape1 = [[(0,0),(1,0),(2,0),(3,0)], [(0,0),(0,1),(0,2),(0,3)]]
shape2 = [[(0,0), (1,0), (2,0), (2,1)], [(0,0), (1,0), (0,1), (0,2)], [(0,0), (0,1), (1,1), (2,1)], [(0,0), (1,0), (1,-1), (1,-2)], [(0,0), (0,1), (1,0), (2,0)], [(0,0), (1,0), (1,1), (1,2)], [(0,0), (1,0), (2,0), (2,-1)], [(0,0), (0,1), (0,2), (1,2)]]
shape3 = [[(0,0), (0,1), (1,0), (1,1)]]
shape4 = [[(0,0), (1,0), (1,1), (2,1)], [(0,0), (0,1), (-1,1), (-1,2)], [(0,0), (0,1), (-1,1), (1,0)], [(0,0), (0,1), (1,1), (1,2)]]
shape5 = [[(0,0), (0,1), (0,2), (1,1)], [(0,0), (0,1), (-1,1), (1,1)], [(0,0), (0,1), (0,2), (-1,1)], [(0,0), (0,1), (-1,0), (1,0)]]

for i in range(n):
  for j in range(m):
    calcByShape(i,j,shape1)
    calcByShape(i,j,shape2)
    calcByShape(i,j,shape3)
    calcByShape(i,j,shape4)
    calcByShape(i,j,shape5)

print(maxScore)