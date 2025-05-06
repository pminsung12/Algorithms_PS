from itertools import combinations

n = int(input())
lst = []
for i in range(n):
  lst.append(list(map(int, input().split())))

team_nums=[i for i in range(n)]
min_diff = 1e9
# n은 짝수
for comb in combinations(team_nums, int(n/2)):
  teamA = list(comb)
  teamB = []
  A_score = 0
  B_score = 0
  for i in range(n):
    if i not in teamA:
      teamB.append(i)
  for c in combinations(teamA, 2):
    A_score += lst[c[0]][c[1]]
    A_score += lst[c[1]][c[0]]
  for c in combinations(teamB, 2):
    B_score += lst[c[0]][c[1]]
    B_score += lst[c[1]][c[0]]
  min_diff = min(min_diff, abs(A_score - B_score))
  
print(min_diff)
  
