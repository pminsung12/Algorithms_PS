def solution(phone_book):
    answer = True
    phone_book=sorted(phone_book)
    for i in range(len(phone_book)-1):
        if len(phone_book[i])>len(phone_book[i+1]): 
            continue
        for j in range(len(phone_book[i])):
            if phone_book[i][j]!=phone_book[i+1][j]: 
                break
            elif j==len(phone_book[i])-1:
                answer=False
                break
        if not answer:
            break
            
    return answer