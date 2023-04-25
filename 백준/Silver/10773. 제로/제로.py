import sys
input=sys.stdin.readline

n=int(input())
arr=[]
for i in range(n):
    num=int(input())
    if not num:
        arr.pop()
        continue
    arr.append(num)

print(sum(arr))
    
    


    