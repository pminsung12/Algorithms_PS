import sys
input = sys.stdin.readline

stk_string = input()
stk = []
res = 0
tmp = 1

for i in range(len(stk_string)):
    if stk_string[i] == '(':
        stk.append('(')
        tmp *= 2

    elif stk_string[i] == ')':
        if not stk or stk[-1] != '(':
            res = 0
            break
        if stk_string[i-1] == '(':
            res += tmp
        stk.pop()
        tmp //= 2

    elif stk_string[i] == '[':
        stk.append('[')
        tmp *= 3

    elif stk_string[i] == ']':
        if not stk or stk[-1] != '[':
            res = 0
            break
        if stk_string[i-1] == '[':
            res += tmp
        stk.pop()
        tmp //= 3

if not stk:
    print(res)
else:
    print(0)
