import sys

sys.setrecursionlimit(10**9)

input = sys.stdin.readline

N = int(input())
graph = [[] for _ in range(N + 1)]
dp = [[0, 0] for _ in range(N + 1)]
visited = [False for _ in range(N + 1)]

for _ in range(N - 1):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)


def dp_dfs(start):
    visited[start] = True
    dp[start][0] = 0
    dp[start][1] = 1  # 자신이 얼리어답터일 경우

    for i in graph[start]:
        if not visited[i]:
            dp_dfs(i)
            dp[start][0] += dp[i][1]  # 자신이 얼리어답터가 아니면 자식은 반드시 얼리어답터
            dp[start][1] += min(dp[i][0], dp[i][1])  # 자신이 얼리어답터면 자식은 일수도, 아닐수도


dp_dfs(1)
# print(dp)
print(min(dp[1][0], dp[1][1]))
