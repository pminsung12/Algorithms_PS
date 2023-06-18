def solution(cap, n, deliveries, pickups):
    deliveries=deliveries[::-1]
    pickups=pickups[::-1]
    
    have_to_deliver=0
    have_to_pickup=0
    
    answer=0
    for i in range(n):
        have_to_deliver+=deliveries[i]
        have_to_pickup+=pickups[i]
        
        while have_to_deliver>0 or have_to_pickup>0:
            have_to_deliver -= cap
            have_to_pickup -= cap
            
            answer+= (n-i)*2
    
    
    
    return answer