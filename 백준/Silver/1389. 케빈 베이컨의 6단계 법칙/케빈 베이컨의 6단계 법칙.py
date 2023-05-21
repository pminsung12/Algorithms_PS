from collections import defaultdict, deque
import sys


def bfs(graph, start):
    num = [0] * (n + 1)
    visited = [start]
    q = deque()
    q.append(start)

    while q:
        x = q.popleft()
        for i in graph[x]:
            if i not in visited:
                num[i] = num[x] + 1
                visited.append(i)
                q.append(i)
    return sum(num)


if __name__ == "__main__":
    input = sys.stdin.readline
    graph = defaultdict(list)

    n, m = map(int, input().split())
    for i in range(m):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)

    res = []
    for i in range(1, n + 1):
        res.append(bfs(graph, i))

    print(res.index(min(res)) + 1)
