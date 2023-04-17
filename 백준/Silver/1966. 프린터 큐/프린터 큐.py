import sys
input = sys.stdin.readline

N = int(input())

while(N > 0):
    length, target = list(map(int, input().split()))
    q = list(map(int, input().split()))

    res = 0
    idx_lst = [[imp, index] for index, imp in enumerate(q)]
    
    while True:
        m=max(idx_lst)[0]
        first = idx_lst.pop(0)

        if m > first[0]:
            idx_lst.append(first)

        else:
            res += 1
            if first[1] == target:
                break
    
    
    print(res)
    N -= 1
