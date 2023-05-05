import sys

input = sys.stdin.readline

brk = input()

res, laser = 0, 0
cnt = 0  # 철막대

for i in range(len(brk)):
    if brk[i] == "(" and i+1 != len(brk) and brk[i+1] == ")":
        laser += 1
        res += laser*cnt

    elif brk[i] == "(":
        cnt += 1

    elif brk[i] == ")" and brk[i-1] == '(':
        laser -= 1

    else:
        res += 1
        cnt -= 1

print(res-1)
