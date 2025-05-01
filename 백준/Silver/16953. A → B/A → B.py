# 목표의 끝자리 보기
# 만약 짝수면 /2
# 만약 홀수면 1로 끝나면 -1 하고 10으로 나누기
# 홀순데 1이 아니면 -1 출력 끝
# 반복하다 target 나오면 끝, or 1보다 작은 값 나오면 종료


a,b = map(int, input().split())
cnt=0
while True:
  if b==a:
    print(cnt+1)
    break
  if b<1:
    print(-1)
    break
  n = b % 10
  if n%2==0:
    b/=2
  else:
    if n==1:
      b-=1
      b/=10
    else:
      print(-1)
      break;
  cnt+=1

  
    
