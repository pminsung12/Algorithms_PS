def solution(citations):
    answer = 0
    citations.sort(reverse=True)
    under=0
    up=0
    allh=[]
    for i in range(0,citations[0]+1):
        for j in range(0,len(citations)):
            if citations[j]>=i:
                up+=1
        
        if up>=i:
            allh.append(i)
        under=0
        up=0
    
    return max(allh)