import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**8)

def solution(n, m, x, y, r, c, k):
    global answer
    answer=''
    dr = [(1, 0, 'd'), (0, -1, 'l'), (0, 1, 'r'), (-1, 0, 'u')]

    # 최소거리
    dist = abs(r-x) + abs(c-y)
    if  dist > k or (k-dist)%2==1:
        return 'impossible'
    
    def backtrack(x,y,w, cnt):
        global answer
        if x<1 or x>n or y<1 or y>m:
            return
        if k< cnt+abs(r-x) + abs(c-y):
            return
        if cnt == k:
            if (x,y) == (r,c):
                answer=w
        
        for i in range(4):
            if answer:
                return
            backtrack(x+dr[i][0], y+dr[i][1], w+dr[i][2], cnt+1)
            

    backtrack(x,y,'', 0)
    if answer=='':
        return "impossible"
    else:
        return answer