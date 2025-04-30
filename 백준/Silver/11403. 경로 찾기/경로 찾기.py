n = int(input())
adjList=[]
for i in range(n):
  adjList.append(list(map(int, input().split())))

for k in range(n):
  for i in range(n):
    for j in range(n):
      if(adjList[i][k]==1 and adjList[k][j]==1):
        adjList[i][j]=1

for i in adjList:
  print(' '.join(map(str, i)))


