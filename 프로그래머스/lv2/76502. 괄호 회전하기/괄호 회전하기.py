from collections import deque
def isRight(s):
    stk=[]
    for i in range(len(s)):
        if len(stk)>0:
            if stk[-1]=='(' and s[i]==')':
                stk.pop()
                continue

            if stk[-1]=='{' and s[i]=='}':
                stk.pop()
                continue

            if stk[-1]=='[' and s[i]==']':
                stk.pop()
                continue

            stk.append(s[i])
        else:
            stk.append(s[i])
    if len(stk)==0:
        return 1
    else:
        return 0

def solution(s):
    answer = 0
    slist=list(s)
    
    for i in range(len(s)):
        if isRight(slist):
            answer+=1
        slist.append(slist.pop(0))
    return answer