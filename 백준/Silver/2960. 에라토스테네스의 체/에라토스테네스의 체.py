import sys
input=sys.stdin.readline

N,k=list(map(int,input().split()))
lst=[True]*(N+1)

res=0
for i in range(2,N+1):
    for j in range(i,N+1,i): #i 배수만큼 돌기
        if lst[j] != False:
            lst[j]=False
            res+=1
            if res==k:
                print(j)
                sys.exit()
    