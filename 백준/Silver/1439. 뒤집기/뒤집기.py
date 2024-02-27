s=input()

cnt=1
last=s[0]
for i in range(1,len(s)):
    if last != s[i]:
        cnt+=1
        last=s[i]
if cnt<2:
    print(0)
else:
    print(cnt//2)
    
