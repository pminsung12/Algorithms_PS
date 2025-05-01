import heapq

def dijkstra(start):
  pq = []
  distance = [1e9 for _ in range(n+1)]
  distance[start]=0
  heapq.heappush(pq, (0, start))
  
  while pq:
    dist, now = heapq.heappop(pq)
    if distance[now] < dist:
      continue
    
    for next, c in adjList[now]:
      cost = dist + c
      if cost<distance[next]:
        distance[next] = cost
        heapq.heappush(pq, (cost, next))
  return distance

n, m ,x = map(int, input().split())

# 단방향임
# x에서 집까지 다익스트라 먼저 돌리고 come 배열 생성
# 각각의 학생 집에서 x까지 거리 한번 더 돌리고 거리 합침
# 이것들의 최댓값

adjList = [[] for _ in range(n+1)]
for i in range(m):
  u, v, dist = map(int, input().split())
  adjList[u].append((v,dist))
  
res = []
max_dist=0
come = dijkstra(x)
for i in range(1, n+1):
  go = dijkstra(i)
  max_dist = max(max_dist, go[x]+come[i])
  
print(max_dist)


