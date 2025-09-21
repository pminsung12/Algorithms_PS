from collections import defaultdict
def solution(commands):
    answer = []
    grid = [[0]*51 for i in range(51)]
    parent = [[(r,c) for c in range(51)] for r in range(51)]
    
    def find(r,c):
        if parent[r][c] == (r,c):
            return (r,c)
        pr, pc = parent[r][c]
        parent[r][c] = find(pr, pc)
        return parent[r][c]
    
    def union(r1, c1, r2, c2):
        a = find(r1,c1)
        b = find(r2,c2)
        if a!=b:
            parent[r2][c2] = parent[r1][c1]
    
    def update(r, c, v):
        a, b = find(r,c)
        grid[a][b] = v
    
    def update_val(msg1, msg2):
        for r in range(51) :
            for c in range(51) :
                pr, pc = find(r, c)
                if grid[pr][pc] == msg1 :
                    grid[pr][pc] = msg2
    
    def merge(r1,c1,r2,c2):
        if (r1,c1)==(r2,c2):
            return
        r1,c1 = find(r1,c1)
        r2,c2 = find(r2,c2)
        if grid[r1][c1]!=0:
            union(r1,c1, r2,c2)
        else:
            union(r2, c2, r1, c1)
    
    def unmerge(r,c):
        pr,pc = find(r,c)
        val = grid[pr][pc]
        merge_lst = []
        for i in range(51):
            for j in range(51):
                pi,pj = find(i,j)
                if (pr,pc) == (pi,pj):
                    merge_lst.append((i,j))
        for ar,ac in merge_lst:
            parent[ar][ac] = (ar,ac)
            grid[ar][ac]=0 if (ar,ac) != (r,c) else val
        

    for command in commands:
        c = command.split(' ')
        if c[0] =='UPDATE':
            if len(c)>=4:
                update(int(c[1]), int(c[2]), c[3])
            else:
                update_val(c[1], c[2])
            
        elif c[0]=='MERGE':
            merge(int(c[1]), int(c[2]), int(c[3]), int(c[4]))
            
        elif c[0]=='UNMERGE':
            unmerge(int(c[1]),int(c[2]))
        
        elif c[0] == 'PRINT':
            r,c = find(int(c[1]),int(c[2]))
            if grid[r][c]==0:
                answer.append("EMPTY")
                continue
            answer.append(grid[r][c])
            
    return answer