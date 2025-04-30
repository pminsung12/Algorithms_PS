def solution(n, computers):
    answer = 0
    visited = [0 for i in range(n)]
    
    def bfs(start, visited):
        q = [start]
        visited[start]=1
        while q:
            cur = q.pop(0)
            for i in range(n):
                if computers[cur][i]==1 and visited[i]==0:
                    q.append(i)
                    visited[cur]=1

    
    for i in range(n):
        try:
            bfs(visited.index(0), visited)
            answer+=1
        except:
            break
    
    return answer