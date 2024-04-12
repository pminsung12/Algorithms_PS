class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int endTime = attacks[attacks.length-1][0];
        
        int bandTime=0;
        int cur=health, attackIdx=0;
        
        // 0부터 공격시간
        for(int i=0; i<=endTime; i++){
            // 공격 받았냐? 받았으면 깎기
            // 0 이하로 떨어지면 -1 return
            if (attackIdx<=attacks.length-1 && i==attacks[attackIdx][0]){ // 공격받음
                cur-=attacks[attackIdx][1];
                if(cur<=0) return -1;
                attackIdx+=1;
                bandTime=0; // 붕대 시간 초기화
                continue;
            }
            // 공격 안받았으면 체력 오르기 -> 다감았는지 체크 
            // 다 감았으면 추가체력
            
            cur+=bandage[1];
            bandTime+=1;
            if(bandTime==bandage[0]){ // 붕대 최대 시간 성공
                cur+= bandage[2]; // 추가 체력 지급
                bandTime=0; // 붕대 시간 초기화
            }
            if(cur>health){ // 초과분은 최대체력으로 조정
                cur=health;
            }
            
            
        }
        
        
        return cur;
    }
}