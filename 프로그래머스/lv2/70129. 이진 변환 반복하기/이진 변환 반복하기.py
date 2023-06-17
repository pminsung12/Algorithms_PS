def solution(s):
    answer = []
    cnt=0
    z_cnt=0
    
    while(s!='1'):
        one_cnt = s.count('1')
        z_cnt+=len(s)-one_cnt
        
        s=bin(one_cnt)[2:]
        cnt+=1
    
    return [cnt,z_cnt]