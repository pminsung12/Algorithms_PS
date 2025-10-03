import heapq
from math import inf

def solution(n, paths, gates, summits):
    answer = []
    graph = [[] for _ in range(n+1)]
    for u,v,c in paths:
        graph[u].append([v,c])
        graph[v].append([u,c])
        
    is_summit = [False] * (n+1)
    for s in summits:
        is_summit[s] = True
    
    dist = [inf]*(n+1)
    q=[]
    for gate in gates:
        dist[gate]=0
        heapq.heappush(q, [0,gate])
    
    while q:
        cost, u = heapq.heappop(q)
        if dist[u] < cost or is_summit[u]:
            continue
        for v, c in graph[u]:
            c = max(dist[u], c)
            if dist[v] > c:
                dist[v] = c
                heapq.heappush(q, [c, v])
    result = [-1, inf]
    for summit in sorted(summits):
        if dist[summit] < result[1]:
            result[0] = summit
            result[1] = dist[summit]

    return result