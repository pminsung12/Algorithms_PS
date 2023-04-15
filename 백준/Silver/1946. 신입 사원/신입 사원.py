import sys
input = sys.stdin.readline

T = int(input())

while(T > 0):
    N = int(input())
    score = [list(map(int, input().split())) for _ in range(N)]
    score.sort()
    greatest = score[0][1]
    die = -1
    for i in score:
        if(i[1] < greatest):  # 넌 살아라
            greatest = i[1]
            continue
        die += 1

    print(N-die)

    T -= 1