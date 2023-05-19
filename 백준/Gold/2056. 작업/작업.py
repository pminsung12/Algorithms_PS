from collections import deque, defaultdict
import sys

input = sys.stdin.readline

N = int(input())
times = [0] * (N + 1)
graph = defaultdict(list)

for i in range(1, N + 1):
    lst = list(map(int, input().split()))
    times[i] = lst[0]
    if lst[1] == 0:
        continue
    for j in lst[2:]:
        graph[i].append(j)


for i in range(1, N + 1):
    if i in graph:
        time = 0
        for j in graph[i]:
            time = max(time, times[j])
        times[i] += time

print(max(times))
