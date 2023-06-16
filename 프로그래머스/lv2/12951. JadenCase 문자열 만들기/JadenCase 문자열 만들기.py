def solution(s):
    answer = ''
    s=list(s.lower())
    print(s)

    flag=1
    for i in range(len(s)):
        if s[i] != ' ': #문자면
            if flag: #제일 앞자리면
                s[i]=s[i].upper()
                flag=0

        elif s[i]==' ': #공백이면
            flag=1

    
    
    return ''.join(s)