from itertools import permutations as p

def findShortestPath(name,cur,next):
    right,left=max(next,cur),min(next,cur)
    rightDist=right-left
    leftDist=left+len(name)-right
    return min(rightDist,leftDist)

def solution(name):
    answer = 0
    answer=int(2e9)
    
    #위아래 커서이동만 계산
    changecnt=0
    for i in name:
        changecnt+=min(ord(i)-ord('A'),ord('Z')-ord(i)+1)
    
    #A가 아니라 가야하는 곳 모두 리스트에 저장
    notA=[i for i in range(len(name)) if name[i]!='A' and i !=0] #시작위치는 이동할 필요없으니 제외
    
    cases=p(notA, len(notA))
    for case in cases:
        cur=0
        res=0
        
        for next in case:
            dist=findShortestPath(name,cur,next)
            res+=dist
            cur=next
        answer=min(answer,res)
    
    answer+=changecnt
    return answer