from collections import deque

def solution(n,a,b):
    answer = 0
    flag=0
    q=deque()
    if a>b:
        temp=a
        a=b
        b=temp
    
    for i in range(1,n+1):
        q.append(i)
    while True:
        size=len(q)
        print(size)
        for i in range(int(size/2)):
            x=q.popleft()
            y=q.popleft()
            if(x==a and y==b):
                
                flag=1
                break
            elif x==a or x==b or y==a or y==b:
                if x==a:
                    q.append(x)
                    print(f"append {x}")
                elif y==a:
                    q.append(y)
                    print(f"append {y}")
                elif x==b:
                    q.append(x)
                    print(f"append {x}")
                elif y==b:
                    q.append(y)
                    print(f"append {x}")
            else:
                q.append(x)
        answer+=1
                
        if flag:
            break
    
    
    return answer