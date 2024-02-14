def solution(routes):
    answer = 0
    routes.sort(key=lambda x:x[1])
    print(routes)
    cam=-30001
    for route in routes:
        if route[0] <= cam:
            continue
        else:
            cam=route[1]
            answer+=1
    return answer