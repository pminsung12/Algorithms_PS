N=int(input())
lst=[]
a=0
for a in range(0,N//3+1):
    b=(N-3*a)//5
    if(3*a+5*b==N):
        lst.append(a+b)
if not lst or N==0:
    print(-1)
else:
    print(min(lst))
