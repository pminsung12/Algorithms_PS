from collections import defaultdict

def solution(clothes):
    answer = 0
    cnt=1
    li=[]
    temp=[]
    dic=defaultdict(list)
    for i in clothes:
        dic[i[1]].append(i[0])
    val=list(dic.values())
    
    for i in val:
        cnt*=(len(i)+1) #선택안하는거 포함 +1
        
    
    return cnt-1 #다 선택안하는거 -1