from collections import defaultdict

def solution(id_list, report, k):
    
    answer = [] # 메일 받는 횟수
    
    mail=defaultdict(int)
    id=defaultdict(set) # 중복제거용 set으로 딕셔너리 사용

    for i in report:
        x,y=i.split(' ')
        id[y].add(x) # 신고당한 사람이 key, value set에는 날 신고한 사람 목록
        
    for j in id_list: # 메일 받을 사람 딕셔너리 초기화
        mail[j]=0

    for u,v in id.items():
        if len(v)>=k: # 신고한 사람수가 2명보다 많으면
            for w in v:
                mail[w]+=1
    
    for u,v in mail.items():
        answer.append(v)

    return answer