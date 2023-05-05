import sys

input = sys.stdin.readline

N, S = list(map(int, input().split()))

arr = list(map(int, input().split()))

left, right = 0, 1
cnt = 0

while right <= N and left <= right:
    tmp = arr[left:right]
    total = sum(tmp)

    if total == S:
        cnt += 1
        right += 1
    elif total < S:
        right += 1
    else:
        left += 1

print(cnt)