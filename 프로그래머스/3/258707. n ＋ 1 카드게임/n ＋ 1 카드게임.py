from collections import deque

def solution(coin, cards):
    def check(deck1, deck2, target):
        s = set(deck2)
        for card in deck1:
            if target-card in s:
                deck1.remove(card)
                deck2.remove(target-card)
                return True
        return False
    # 3개로 분류
    n = len(cards)
    # 1. 내 손에 있음
    hand = cards[:n//3]
    # 2. 카드 더미
    deck = deque(cards[n//3:])
    # 3. 뽑은 것
    picked = []
    turn =1
    while coin>=0 and deck:
        # 카드 더미에서 2장 뽑아 뽑은 것으로 이동
        picked.append(deck.popleft())
        picked.append(deck.popleft())
        
        # 내 손에서 2장 내기
        if(check(hand, hand, n+1)):
            pass
        # 내 손에서 1장, 뽑은 것에서 1장 내기
        elif coin>=1 and check(hand, picked, n+1):
            coin-=1
        # 뽑은 것에서 2장 내기
        elif coin>=2 and check(picked, picked, n+1):
            coin-=2
        else:
            break
        turn+=1
        
    
    return turn