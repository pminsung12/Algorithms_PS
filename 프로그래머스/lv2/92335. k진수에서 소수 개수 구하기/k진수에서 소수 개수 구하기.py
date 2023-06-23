def solution(n, k):
    answer = 0
    changed=[]
    while(n!=0):
        changed.insert(0,str(n%k))
        n//=k
    number=''.join(changed)

    def isPrimeNumber(n):
        if n==0 or n==1:
            return False
        
        for i in range(2,int(n**(1/2))+1):
            if n%i == 0 :
                return False
        return True
    
    if len(number)==1:
        if isPrimeNumber(int(number)):
            return 1
        else:
            return 0
    
    pn=""
    for i in number:
        if i=='0':
            if isPrimeNumber(int(pn)):
                answer+=1
            pn=""
        
        pn+=i
    
    if isPrimeNumber(int(pn)):
        answer+=1
        
    return answer