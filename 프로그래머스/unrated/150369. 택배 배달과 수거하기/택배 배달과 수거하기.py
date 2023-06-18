def solution(cap, n, deliveries, pickups):
    deliveries=deliveries[::-1]
    pickups=pickups[::-1]
    
    cnt_deliver=0
    cnt_pickup=0
    
    answer=0
    for i in range(n):
        cnt_deliver+=deliveries[i]
        cnt_pickup+=pickups[i]
        
        while cnt_deliver>0 or cnt_pickup>0:
            cnt_deliver -= cap
            cnt_pickup -= cap
            
            answer+= (n-i)*2
    
    return answer