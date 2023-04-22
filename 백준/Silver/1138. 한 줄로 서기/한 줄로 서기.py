import sys
input = sys.stdin.readline

N = int(input())
line = list(map(int, input().split()))

res = [0]*N

for i in range(N):
    cnt = 0
    for j in range(N):
        if cnt == line[i] and res[j] == 0:  # 키큰 사람도 맞고 자리에 아무도 없으면 그자리 픽스
            res[j] = i+1
            break

        elif res[j] == 0:  # 키큰 사람 수가 안맞는데 그 자리에 아무도 없으면 그 자리는 키큰 사람이 온다는 거니까 키큰 사람+1
            cnt += 1

        else:
            # 키는 사람 수가 안맞고 그 자리에 사람이 있으면 나보다 작은 사람이니까(키 순서대로 for문이니까) 키큰 사람 수 변동 x
            continue

print(*res)
