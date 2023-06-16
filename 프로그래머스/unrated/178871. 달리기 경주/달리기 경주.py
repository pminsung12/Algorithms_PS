from collections import Counter

def solution(players, callings):
    ptoi={p:i for i,p in enumerate(players)}
    itop={i:p for i,p in enumerate(players)}
    
    for p in callings:
        i=ptoi[p] #현재 등수
        prev_p=itop[i-1] #이전플레이어 이름
        
        #등수 조정
        ptoi[p]-=1
        ptoi[prev_p]+=1
        
        #등수에 맞는 이름 조정
        itop[i]=prev_p
        itop[i-1]=p
        
    answer=sorted(ptoi, key=lambda x:ptoi[x])
        
                
    
    return answer