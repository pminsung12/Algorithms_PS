from collections import defaultdict

def solution(id_list, report, k):
    
    answer = [] # 메일 받는 횟수
    
    mail=defaultdict(int)
    id=defaultdict(int)

    for i in set(report):
        id[i.split()[1]]+=1 # 신고당한 사람이 key, 신고한사람 수가 value
        
    for j in id_list: # 메일 받을 사람 딕셔너리 초기화
        mail[j]=0

    for m in set(report):
        if id[m.split()[1]]>=k:
            mail[m.split()[0]]+=1
    
    for u,v in mail.items():
        answer.append(v)

    return answer