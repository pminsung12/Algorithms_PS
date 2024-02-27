import heapq

def solution(operations):
    answer = []
    min_heap=[]
    
    for i in operations:
        c,d=i.split()
        if c=='I':
            data=int(d)
            heapq.heappush(min_heap, data)
        
        elif min_heap: # D일 때 
            if d=='1': # 최댓값 삭제
                min_heap=heapq.nlargest(len(min_heap), min_heap)[1:]
                heapq.heapify(min_heap)
            else: # 최솟값 삭제
                heapq.heappop(min_heap)
    
    
    return [heapq.nlargest(len(min_heap), min_heap)[0], heapq.heappop(min_heap)] if min_heap else [0,0]