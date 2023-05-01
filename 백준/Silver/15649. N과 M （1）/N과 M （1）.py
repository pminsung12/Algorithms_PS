import itertools
import sys

input=sys.stdin.readline

N,M=list(map(int,input().split()))

arr=[i for i in range(1,N+1)]
res=list(itertools.permutations(arr,M))

for i in res:
    for j in i:
        print(j, end=" ")
    print()