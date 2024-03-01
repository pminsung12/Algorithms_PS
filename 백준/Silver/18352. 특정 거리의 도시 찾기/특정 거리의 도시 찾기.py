import heapq
import sys
f=sys.stdin.readline

INF=int(1e9)

def dijkstra(x):
    q=[]
    heapq.heappush(q,(0,x))
    distance[x]=0
    while q:
        dist, n=heapq.heappop(q)
        if distance[n]<dist:
            continue
        for d, i in graph[n]:
            cost=dist+d
            if cost<distance[i]:
                distance[i]=cost
                heapq.heappush(q,(cost, i))


n,m,k,x=map(int, f().split())

graph=[[] for _ in range(n+1)]
distance=[INF]*(n+1)
for i in range(m):
    u,v=map(int, f().split())
    graph[u].append((1,v))

dijkstra(x)

answer=[]
isNull=1
for i in range(1,len(distance)):
    if distance[i]==k:
        isNull=0
        print(i)
if isNull:
    print(-1)
