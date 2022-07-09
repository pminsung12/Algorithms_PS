def solution(brown, yellow):
    answer = []
    total=brown+yellow
    for i in range(3,total+1):
        if total%i==0:
            if i*2+total/i*2-4==brown or i*2+total/i*2-4==yellow:
                answer.append(i)
                answer.append(total/i)
                break
    answer.sort(reverse=True)
    return answer