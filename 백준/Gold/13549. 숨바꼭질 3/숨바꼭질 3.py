import heapq

INF=int(1e9)
ans=INF
x,y=map(int,input().split())
distance=[INF]*100001

def dijkstra(start):
    q=[]
    heapq.heappush(q,(0,start))
    distance[start]=0
    while q:
        dist, n=heapq.heappop(q)
        
        if distance[n] < dist :
            continue
        
        if distance[y] < dist:
            break
        
        # X-1
        cost=distance[n]+1
        if n-1>=0 and cost < distance[n-1]:
            distance[n-1]=cost
            heapq.heappush(q,(cost,n-1))
        
        # X+1
        cost=distance[n]+1
        if n+1<=y and cost < distance[n+1]:
            distance[n+1]=cost
            heapq.heappush(q,(cost,n+1))
        
        # X*2
        cost=distance[n]
        if  n*2<=y*2 and n*2<=100000 and cost < distance[2*n]:
            distance[n*2]=cost
            heapq.heappush(q,(cost,n*2))
        
dijkstra(x)
print(distance[y])