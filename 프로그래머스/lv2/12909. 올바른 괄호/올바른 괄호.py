def solution(s):
    answer = True
    stk=[]
    for i in s:
        if i=='(':
            stk.append('(')
        elif i==')' and not stk:
            return False
            
        else:
            stk.pop()
    
    if not stk:
        return True
    
    return False