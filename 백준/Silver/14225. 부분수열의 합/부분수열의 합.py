import sys

input=sys.stdin.readline

N=int(input())
arr=list(map(int,input().split()))


res=set()

def part(arr,i,chk,tmp):
    if i==len(arr):
        res.add(tmp)
        return
    if chk:
        tmp+=arr[i]
    i+=1
    part(arr,i,0,tmp)
    part(arr,i,1,tmp)
    
part(arr,0,0,0)
part(arr,0,1,0)

res2=sorted(res)
# print(res2)

for i in range(1,20000001):
    if i>res2[len(res2)-1]:
        print(i)
        break
    if i!=res2[i]:
        print(i)
        break