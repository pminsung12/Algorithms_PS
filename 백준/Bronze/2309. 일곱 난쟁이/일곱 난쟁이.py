from itertools import combinations

lst = []
for i in range(9):
  lst.append(int(input()))

lst.sort()
for comb in combinations(lst, 7):
  if sum(comb)==100:
    for l in comb:
      print(l)
    break
