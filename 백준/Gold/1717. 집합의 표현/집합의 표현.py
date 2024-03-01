from collections import defaultdict
import sys
input=sys.stdin.readline

sys.setrecursionlimit(10**9)

def find(x):
    if parent[x]!=x:
        parent[x]=find(parent[x])
    return parent[x]

def union(a,b):
    a=find(a)
    b=find(b)
    if a<b:
        parent[b]=a
    else:
        parent[a]=b

n, m=map(int,input().split())

parent=defaultdict()
for i in range(0,n+1):
    parent[i]=i

for i in range(m):
    c,u,v=map(int, input().split())
    
    if c==0:
        union(u,v)
    else: # c==1
        if find(u)==find(v):
            print("yes")
        else:
            print("no")
