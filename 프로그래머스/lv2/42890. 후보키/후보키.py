from itertools import combinations
def solution(relation):
    answer=0
    row=len(relation)
    col=len(relation[0]) #key
    
    #전체 속성 인덱스 조합
    combi=[]
    for i in range(1,col+1):
        combi.extend(combinations(range(col),i))
    
    #유일성 검사
    uniq=[]
    for i in combi:
        tmp=[tuple([item[key] for key in i]) for item in relation] #[(100,ryan),(200,appeach),(300,tube)...]
        if len(set(tmp))==row: #중복이 없으면
            isMin = True
            
            #최소성 체크
            for x in uniq:
                if set(x).issubset(set(i)):
                    isMin=False
            
            if isMin:
                uniq.append(i)
    
    return len(uniq)