from itertools import combinations, product
from bisect import bisect_left

def solution(dices):
    dic={}
    L = len(dices)
    for A_index_comb in combinations(range(L), L//2):
        B_index_comb = [i for i in range(L) if i not in A_index_comb]
        
        A=[]
        B=[]
        for dice_idx in product(range(6), repeat=L//2):
            A.append(sum(dices[i][j] for i, j in zip(A_index_comb, dice_idx)))
            B.append(sum(dices[i][j] for i, j in zip(B_index_comb, dice_idx)))
        
        B.sort()
        wins = sum(bisect_left(B, num) for num in A)
        dic[wins] = A_index_comb
    
    max_win = max(dic.keys())
    return [i+1 for i in dic[max_win]]