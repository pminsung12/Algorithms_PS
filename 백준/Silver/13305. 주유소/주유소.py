import sys
input = sys.stdin.readline

N = int(input())
dist_lst = list(map(int, input().split()))
money_lst = list(map(int, input().split()))

# print(dist_lst)
# print(money_lst)

res = 0
cheapest = 1000000001

for i in range(len(dist_lst)):
    if money_lst[i] < cheapest:
        cheapest = money_lst[i]
    res += cheapest*dist_lst[i]
    

print(res)