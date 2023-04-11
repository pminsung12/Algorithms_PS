N=int(input())
b=0
chk=0
for b in range(N//5,-1,-1):
    if((N-5*b)%3==0):
        chk=1
        break
if  chk==0:
    print(-1)
else:
    print(b+(N-5*b)//3)
