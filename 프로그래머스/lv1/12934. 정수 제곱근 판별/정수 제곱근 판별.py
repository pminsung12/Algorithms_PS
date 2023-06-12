def solution(n):
    answer = 0
    for i in range(1,n+1):
        if i**2==n:
            answer=(i+1)**2
            break
        if i**2>n:
            break
    if answer==0:
        return -1
    return answer

