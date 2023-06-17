def solution(cacheSize, cities):
    answer = 0
    cache=[]
    
    if cacheSize==0:
        return 5*len(cities)
    
    for i in range(len(cities)):
        city = cities[i].lower()
        
        if city in cache:
            cache.remove(city)
            cache.append(city)
            answer+=1
        
        else:
            if len(cache)==cacheSize:
                cache.pop(0)
            cache.append(city)
            answer+=5
        
    return answer