answer=0
def dfs(numbers, res,i, target):
    global answer
    if i==len(numbers):
        if res==target:
            answer+=1
        return
    dfs(numbers,res+numbers[i], i+1, target)
    dfs(numbers,res-numbers[i], i+1, target)

def solution(numbers, target):
    dfs(numbers,0,0, target)
    return answer