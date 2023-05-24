import sys
import heapq

if __name__ == "__main__":
    input = sys.stdin.readline

    n = int(input())
    m = int(input())

    arr = [[] for _ in range(n + 1)]
    for i in range(m):
        a, b, c = map(int, input().split())
        arr[a].append((b, c))

    prev_node = [0] * (n + 1)
    x, y = map(int, input().split())

    def dijkstra(start):
        distances = [1e9] * (n + 1)
        distances[start] = 0
        q = []
        heapq.heappush(q, [distances[start], start])

        while q:
            dist, node = heapq.heappop(q)

            # 밑에 for문에서 distances[node]값이 갱신될 수 있음
            # 현재 노드가 이미 처리된 적이 있는 노드라면 처음 처리한게 항상 최단거리이므로 무시
            if dist > distances[node]:
                continue

            for n_node, n_dist in arr[node]:
                distance = dist + n_dist
                if distance < distances[n_node]:
                    distances[n_node] = distance
                    prev_node[n_node] = node
                    heapq.heappush(q, [distance, n_node])

        return distances

    min_cost = dijkstra(x)
    print(min_cost[y])

    z = y
    path = []
    while True:
        if z == x:
            break
        path.append(z)
        z = prev_node[z]
    print(len(path) + 1)
    print(x, *path[::-1])
