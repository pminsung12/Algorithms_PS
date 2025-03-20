def solution(edges):
    dic = {}
    answer = [0,0,0,0]
    # [나감, 들어옴] 개수 정보를 담고 있는 그래프 정보 만들기
    for u, v in edges:
        if not dic.get(u):
            dic[u] = [0,0]
        if not dic.get(v):
            dic[v] = [0,0]
        
        dic[u][0]+=1
        dic[v][1]+=1
    
    # 다 이어주는 노드 -> 나감>=2, 들어옴 0
    # 막대 판별 -> 맨 끝 노드가 들어옴 1, 나감 0
    # 8자 판별 -> 중간 노드가 들어옴2, 나감 2
    # 도넛 판별 -> 다 이어주는 노드의 간선 수 - 막대 - 8자
    for node, count in dic.items():
        if count[1]==0 and count[0]>=2:
            answer[0] = node
            
        elif count[1]>0 and count[0]==0:
            answer[2]+=1
            
        elif count[1]>=2 and count[0]>=2:
            answer[3]+=1
            
    answer[1] = dic[answer[0]][0] - answer[2] - answer[3]
    
    return answer