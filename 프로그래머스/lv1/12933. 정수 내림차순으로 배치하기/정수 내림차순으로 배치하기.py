def solution(n):
    sn=str(n)
    a=[]
    for i in sn:
        a.append(i)
    a=sorted(a,reverse=True)
    answer=''
    for j in a:
        answer+=j
    
    return int(answer)