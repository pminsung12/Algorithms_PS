import itertools

def check(s):
    if s==1 or s==0:
        return False
    for i in range(2,s):
        if(s%i==0):
            return False
    return True

def solution(numbers):
    answer = 0
    res=set()
    pm=[]
    for i in range(1,len(numbers)+1):
        pm=list(map(''.join,itertools.permutations(numbers,i)))
        for j in pm:
            if check(int(j))==True:
                res.add(int(j))
    print(res) 
    return len(res)