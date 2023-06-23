def solution(n, k):
    answer = 0
    changed=''
    while(n!=0):
        n,mod=divmod(n,k)
        changed+=str(mod)
    number=changed[::-1]
    number=number.split('0')
    print(number)
    def isPrimeNumber(n):
        if n==0 or n==1:
            return False
        
        for i in range(2,int(n**(1/2))+1):
            if n%i == 0 :
                return False
        return True
    
    for k in number:
        if k.isdigit():
            if isPrimeNumber(int(k)):
                answer+=1
    return answer