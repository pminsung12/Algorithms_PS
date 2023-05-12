# 최단경로-> DFS 보단 BFS
from collections import deque
import sys

input = sys.stdin.readline
N, M = list(map(int, input().split()))

graph = [list(map(int, " ".join(input().split()))) for _ in range(N)]

# print(graph)

def BFS(x, y):
    q = deque([(x, y)])

    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            # 유효 범위 체크
            if -1 < nx < N and -1 < ny < M:
                # 벽이 아니면
                if graph[nx][ny] == 1:
                    q.append((nx, ny))
                    # value를 거리 값으로 업데이트, 이때 항상 최소가 유지됨.
                    graph[nx][ny] = graph[x][y] + 1 

    return graph[N - 1][M - 1]


print(BFS(0, 0))
