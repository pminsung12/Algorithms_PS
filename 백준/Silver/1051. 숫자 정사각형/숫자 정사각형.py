import sys
input = sys.stdin.readline

rect = []
n, m = list(map(int, input().split()))
for i in range(n):
    rect.append(list(input()))

temp = min(n, m)
answer=0

for i in range(n):
    for j in range(m):
        for k in range(temp):
            if i+k<n and j+k<m and (rect[i][j]==rect[i][j+k] ==rect[i+k][j]==rect[i+k][j+k]):
                answer=max(answer,(k+1)**2)
print(answer)
            