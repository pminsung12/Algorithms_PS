def solution(n, tops):
    # dp
    MOD = 10007
    
    # a[k]는 k번째 사다리꼴을 3번 마름모로 했을 때
    # b[k]는 의외의 방법 : 1,2,4로 채웠을 때, 1은 top이 있을 때임, 4는 다 정삼각형
    a = [0 for _ in range(n)]
    b = [0 for _ in range(n)]
    
    a[0]=1
    b[0]=3 if tops[0] else 2
    
    for k in range(1,n):
        if tops[k]:
            a[k] = a[k-1]+b[k-1] # 이전에 어떻게 했든 상관 없음.
            b[k] = a[k-1]*2 + b[k-1]*3 # 3번 했는건 1,4, 3번 안했는건 1,2,4
        else:
            a[k] = a[k-1]+b[k-1]
            b[k] = a[k-1] + b[k-1]*2
        
        a[k]%=MOD
        b[k]%=MOD
            
    
    return (a[-1]+b[-1])%MOD