def solution(n, words):
    answer = []
    s=set()
    idx=0
    last = ''
    for word in words:
        if (word in s) or (word!=words[0] and word[0]!=last):
            answer.append((idx)%n+1)
            answer.append((idx//n)+1)
            break
        s.add(word)
        idx+=1
        last = word[-1]
    if(len(answer)==0):
        return[0,0]
    return answer