import heapq

def dijkstra(start):
  pq = []
  distance = [INF]*(n+1)
  heapq.heappush(pq, (0, start))
  distance[start]=0
  while pq:
    dist, cur = heapq.heappop(pq)
    
    if distance[cur] < dist:
      continue
    
    for c, next in adjList[cur]:
      cost = c + distance[cur]
      
      if cost < distance[next]:
        distance[next] = cost
        heapq.heappush(pq, (cost,next))
      
  return distance

INF = int(1e9)

n, e = map(int, input().split())
adjList = [[] for _ in range(n+1)]
for i in range(e):
  u, v, dist = map(int, input().split())
  adjList[u].append((dist,v))
  adjList[v].append((dist,u))
v1, v2 = map(int, input().split())

# 1->v1->v2->n
# 1->v2->v1->n
# 비교해서 둘 중 최솟값 출력

from_1_dist = dijkstra(1)
from_v1_dist = dijkstra(v1)
from_v2_dist = dijkstra(v2)

cost_1_v1_v2 = from_1_dist[v1]+from_v1_dist[v2]+from_v2_dist[n]
cost_1_v2_v1 = from_1_dist[v2]+from_v2_dist[v1]+from_v1_dist[n]

res = min(cost_1_v1_v2, cost_1_v2_v1)
print(res if res<INF else -1)
