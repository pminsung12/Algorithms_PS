def solution(priorities, location): 
    answer = 0
    temp,flag=0,0
    while(location>=0 and priorities):
        temp=priorities.pop(0)
        for i in priorities:
            if i>temp:
                priorities.append(temp)
                flag=1
                break
        if not flag: #출력
            answer+=1
        elif location==0:#뒤로보내고 그 자리면
            location+=len(priorities)
        flag=0
        location-=1
    
    return answer