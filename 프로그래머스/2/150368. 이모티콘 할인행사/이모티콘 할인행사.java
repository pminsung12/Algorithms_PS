class Solution {
    
    static int sign = 0;
    static int earn = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int[] comb = new int[emoticons.length];
        
        generate_product(comb, 0, users, emoticons);
        
        answer[0] = sign;
        answer[1] = earn;
        
        return answer;
    }
    
    static void generate_product(int[] comb, int depth, int[][] users, int[] emoticons){
        if(depth == comb.length){
            solve(comb, users, emoticons);
            return;
        }
        
        for(int i=10; i<=40; i+=10){
            comb[depth] = i;
            generate_product(comb, depth+1, users, emoticons);
        }
    }
    
    
    static void solve(int[] comb, int[][] users, int[] emoticons){
        int emti_plus=0;
        int users_total = 0;
        for(int[] user: users){
            int sum=0;
            int rate = user[0];
            int price = user[1];
            for(int i=0; i<comb.length; i++){
                if(comb[i]>=rate){ 
                    // 구매
                    sum += (100-comb[i])*(emoticons[i]/100);
                }
            }
            
            
            if(sum>=price){
                emti_plus++;
            } else {
                users_total+=sum;
            }
            
        }
        if(emti_plus>sign){
            sign = emti_plus;
            earn = users_total;
        } else if(sign == emti_plus){
            if(users_total>earn){
                earn = users_total;
            }
        }
        
        return;
    }
    
    
}