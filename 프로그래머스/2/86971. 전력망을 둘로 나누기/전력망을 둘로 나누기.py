from collections import deque

def solution(n, wires):
    answer = n-2
    
    graph = [[] for i in range(n+1)]
    for wire in wires:
        graph[wire[0]].append(wire[1])
        graph[wire[1]].append(wire[0])
    
    
    
    def bfs(start):
        q = deque()
        q.append(start)
        visited = [False] *(n+1)
        visited[start] = True
        cnt=0
        while q:
            cur = q.popleft();
            for next in graph[cur]:
                if not visited[next]:
                    q.append(next)
                    visited[next] = True
                    cnt+=1
        return cnt
    
    for wire in wires:
        a = wire[0]
        b = wire[1]
        graph[a].remove(b)
        graph[b].remove(a)
        answer = min(abs(bfs(a)- bfs(b)), answer)
        
        graph[a].append(b)
        graph[b].append(a)
        
            
    
    return answer