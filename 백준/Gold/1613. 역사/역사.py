import sys

if __name__ == "__main__":
    input = sys.stdin.readline

    n, k = map(int, input().split())
    arr = [[0] * (n + 1) for _ in range(n + 1)]

    for i in range(k):
        a, b = map(int, input().split())
        arr[a][b] = 1

    # 플로이드-워셜 알고리즘
    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                if arr[i][k] + arr[k][j] == 2:
                    arr[i][j] = 1

    s = int(input())
    for j in range(s):
        x, y = map(int, input().split())
        if arr[x][y] == 1:  # x가 y보다 먼저
            print(-1)
        elif arr[y][x] == 1:  # y가 x보다 먼저
            print(1)
        else:
            print(0)
