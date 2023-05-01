import itertools
import sys

input=sys.stdin.readline

N,S=list(map(int,input().split()))

arr=list(map(int,input().split()))

res=0
for i in range(1,N+1):
    comb=list(itertools.combinations(arr,i))
    for j in comb:
        if sum(j)==S:
            res+=1
print(res)