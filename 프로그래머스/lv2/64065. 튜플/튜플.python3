def solution(s):
    answer = []
    numbers=[]
    count={}
    temp=""
    for i in s:
        if i.isdigit():
            temp+=i
        else:
            if temp:
                numbers.append(int(temp))
            temp=""
    for value in numbers:
        try: count[value]+=1
        except: count[value]=1
    answer=sorted(count,key=lambda x:count[x],reverse=True)
    
    return answer