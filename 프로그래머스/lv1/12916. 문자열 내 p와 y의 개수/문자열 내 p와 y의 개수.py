def solution(s):
    p,y=0,0
    for i in s:
        if i=='P' or i=='p':
            p+=1
        elif i=='Y' or i=='y':
            y+=1
    if p==y:
        return True
    else :
        return False