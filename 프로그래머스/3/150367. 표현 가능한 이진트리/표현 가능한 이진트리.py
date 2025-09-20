def solution(numbers):
    answer = []
    # 0101010
    def check(number):
        # 1. binary로 변환
        bin_number = bin(number)[2:]
        # 2. 빈 곳 0으로 채우기
        k=1
        n = len(bin_number)
        while 2**(k)-1 < n:
            k+=1
        if 2**(k) -1 != n:
            bin_number = '0'*((2**(k) -1)-n)  + bin_number
            n = len(bin_number)

        def checkRoot(start, end):
            if start > end :
                return 1
            # 루트 위치
            mid = (start+end)//2
            # 루트 노드가 0이면, 자식들도 모두 0이어야 함
            if bin_number[mid]=='0':
                for i in range(start, end+1):
                    if bin_number[i]=='1':
                        return 0
                return 1
            return checkRoot(start, mid-1) and checkRoot(mid+1, end)
        
        return checkRoot(0, n - 1)

    for number in numbers:
        answer.append(check(number))
    
    return answer