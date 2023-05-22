from collections import defaultdict
import sys
import heapq


def dijkstra(graph, start):
    distances = [1e9] * (n + 1)
    distances[start] = 0
    q = []
    heapq.heappush(q, [distances[start], start])

    while q:
        dist, node = heapq.heappop(q)

        if dist > distances[node]:
            continue

        for n_node, n_dist in graph[node]:
            distance = dist + n_dist
            if distance < distances[n_node]:
                distances[n_node] = distance
                heapq.heappush(q, [distance, n_node])
    return distances


if __name__ == "__main__":
    input = sys.stdin.readline

    n, m = map(int, input().split())
    start = int(input())
    graph = defaultdict(list)

    for i in range(m):
        a, b, c = map(int, input().split())
        graph[a].append((b, c))

    dist_lst = dijkstra(graph, start)
    for i in range(1, n + 1):
        if dist_lst[i] == 1e9:
            print("INF")
            continue
        print(dist_lst[i])
