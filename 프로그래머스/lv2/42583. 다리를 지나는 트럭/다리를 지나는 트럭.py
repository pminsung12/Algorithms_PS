from collections import deque

def solution(bl, w, tw):
    answer = 0
    bridge=[0 for _ in range(bl)]
    
    while bridge:
        answer+=1
        bridge.pop(0)
        if tw:
            if sum(bridge)+tw[0]<=w:
                t=tw.pop(0)
                bridge.append(t)
            else:
                bridge.append(0)
    
    return answer