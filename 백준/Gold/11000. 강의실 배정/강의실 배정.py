import sys
import heapq
input = sys.stdin.readline

N = int(input())
class_list = [list(map(int, input().split())) for _ in range(N)]


class_list.sort()

end_time = []  # 강의실당 제일 늦게 끝나는 시간 저장
heapq.heappush(end_time, class_list[0][1])

for i in range(1, N):
    if(class_list[i][0] < end_time[0]):  # 시작시간<제일 빨리 끝나는 강의실 시간
        heapq.heappush(end_time, class_list[i][1])  # 강의실 추가
    else:
        heapq.heappop(end_time)
        heapq.heappush(end_time, class_list[i][1])

print(len(end_time))
