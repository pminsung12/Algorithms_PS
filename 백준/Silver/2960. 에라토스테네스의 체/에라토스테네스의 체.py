import sys
input=sys.stdin.readline

N,k=list(map(int,input().split()))
lst=[_ for _ in range(2,N+1)]
# print(lst)

res=0
for i in range(2,N+1):
    j=0
    while True:
        # print(j,"j번째")
        length=len(lst)
        if j==length:
            break
        if lst[j]%i==0:
            res=lst.pop(j)
            j-=1
            k-=1
            # print("res", res)
            # print(lst, len(lst))
            
        if not k:
            break
        j+=1
    if not k:
        break
print(res) 