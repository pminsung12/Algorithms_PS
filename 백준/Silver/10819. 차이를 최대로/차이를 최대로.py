from itertools import permutations

n = int(input())
nums = list(map(int, input().split()))

def calc(p):
  res=0
  for i in range(0, n-1):
    res+=abs(p[i]-p[i+1])
  return res
    
max_val=0
for p in permutations(nums, n):
  max_val = max(max_val, calc(p))

print(max_val)