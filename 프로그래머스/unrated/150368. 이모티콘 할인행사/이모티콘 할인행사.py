from itertools import product # 중복순열

def userSpent(emoticons, ratio, user_rate): # 유저가 조건을 만족해서 사는 이모티콘 총합
    return sum([emoticons[i]*(1-(ratio[i]/100)) for i in range(len(emoticons)) if ratio[i]>=user_rate])

def solution(users, emoticons):
    answer=[]
    
    for ratio in product([10,20,30,40], repeat=len(emoticons)):
        emti_plus, total=0,0
        for user in users:
            res=userSpent(emoticons, ratio, user[0])
            if res >=user[1]:
                emti_plus+=1
                continue
            total+=res
        answer.append([emti_plus,total])
    
    return sorted(answer, reverse=True)[0]