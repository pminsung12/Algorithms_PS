def solution(park, routes):
    answer = []
    h=len(park)
    w=len(park[0])
    
    for i in range(h):
        for j in range(w) :
            if park[i][j]=='S':
                pos=(i,j)
    
    
    
    for i in routes:
        flag=0
        x,y=pos
        u=i.split()[0]
        v=int(i.split()[1])
        
        if u=='E' and y+v < w:
            for j in range(v):
                if park[x][y+j+1]=='X':
                    flag=1
                    break
            if not flag:
                pos=(x,y+v)
        elif u=='S'and x+v < h:
            for j in range(v):
                if park[x+j+1][y]=='X':
                    flag=1
                    break
            if not flag:
                pos=(x+v,y)
        elif u=='W' and -1 < y-v:
            for j in range(v):
                if park[x][y-(j+1)]=='X':
                    flag=1
                    break
            if not flag:
                pos=(x,y-v)
        elif u=='N'and -1 < x-v:
            for j in range(v):
                if park[x-(j+1)][y]=='X':
                    flag=1
                    break
            if not flag:
                pos=(x-v,y)
    answer=pos
    
    return answer