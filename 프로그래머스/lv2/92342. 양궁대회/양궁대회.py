from collections import defaultdict
from itertools import combinations_with_replacement

def whowin(apeach, ryan, win_dic):
    a_score, r_score = 0, 0
    for i in range(11):
        if apeach[i] >= ryan[i]:
            if apeach[i]==0:
                continue
            a_score += 10-i
        else:
            r_score += 10-i
    
    if r_score>a_score:
        win_dic[r_score-a_score].append(ryan)
    
    return win_dic


def solution(n, info):
    cwr=list(combinations_with_replacement([i for i in range(11)],n))
    cases=[]
    win_dic=defaultdict(list)
    
    for c in cwr: # 라이언의 모든 중복 조합을 개수로 변환
        ryan=[0]*11
        for i in c:
            ryan[i]+=1
        cases.append(ryan)
    
    for case in cases:
        win_dic=whowin(info, case, win_dic)
    
    if not win_dic:
        return [-1]
    
    answer=win_dic[max(win_dic.keys())]
    answer.sort(key=lambda x:[-x[i] for i in range(10,-1,-1)])
    
    return answer[0]