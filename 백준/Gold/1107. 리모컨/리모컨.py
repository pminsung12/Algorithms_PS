import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
spoiled = list(input().split())

min_val = abs(n-100)
# 채널 자체는 무한대, 두배 만큼
for i in range(1000001):
  chan = str(i)
  for j in range(len(chan)):
    if chan[j] in spoiled:
      break
    
    if j==len(chan)-1:
      min_val = min(min_val, abs(i-n)+len(chan))
  
print(min_val)