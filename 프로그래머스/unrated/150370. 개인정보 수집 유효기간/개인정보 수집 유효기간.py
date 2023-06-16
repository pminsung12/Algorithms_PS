def dateChanger(date): #년월일을 일 총합으로 변환
    year,month,day=map(int,date.split('.'))
    return (year-2000)*12*28+month*28+day

def solution(today, terms, privacies):
    answer = []
    t={} # 약관 이름: 유효기간인 딕셔너리
    for i in terms:
        a,b=i.split()
        t[a]=int(b)
        
    today=dateChanger(today)
    for j in range(len(privacies)):
        date,term = privacies[j].split()
        changed_d=dateChanger(date)
        if today-changed_d >= t[term]*28:
            answer.append(j+1)

    return answer
