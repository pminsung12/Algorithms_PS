def solution(s):
    answer = []
    cnt=0
    z_cnt=0
    
    while(s!='1'):
        for i in range(len(s)):
            if s[i]=='0':
                z_cnt+=1
        s=format(len(s.replace('0','')),'b')
        
        cnt+=1
    
    return [cnt,z_cnt]