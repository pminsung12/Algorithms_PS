from itertools import permutations

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        answer = []
        def backtrack(start, end):
            if(start == end):
                answer.append(nums[:])
                return
            for i in range(start, end):
                nums[start], nums[i] = nums[i], nums[start]  # 스왑
                backtrack(start + 1, end)  # 다음 인덱스로 진행
                nums[start], nums[i] = nums[i], nums[start]  # 원상복구 (백트래킹)
        backtrack(0,len(nums))
        return answer
        # return list(permutations(nums, len(nums)))
        