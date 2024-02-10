# 전략: 어쨋든 앞 자리 숫자가 커야 숫자가 커진다. 앞의 작은 숫자들을 최대한 많이 쳐내는 것이 목표
def solution(number, k):
    answer_len=len(number)-k
    stk=[]
    for num in number:
        while stk and num > stk[-1] and k>0:
            stk.pop()
            k-=1
        stk.append(num)
    return ''.join(stk[:answer_len])