cnt, N=map(int,input().split())
num_list=[]
for i in range(cnt):
    num_list.append(int(input()))
res=0
for i in range(len(num_list)-1,-1,-1):
    if(N==0): 
        break
    if(N//num_list[i]==0):
        continue
    res+=N//num_list[i]
    N%=num_list[i]
print(res)