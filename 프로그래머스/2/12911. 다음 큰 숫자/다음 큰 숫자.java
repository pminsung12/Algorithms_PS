class Solution {
    public int solution(int n) {
        int answer = 0;
        int nCnt = intToBin(n);
        while(true){
            n++;
            int tmpCnt =intToBin(n);
            if(nCnt == tmpCnt){
                break;
            }
        }        
        return n;
    }
    
    public int intToBin(int n){
        int cnt=0;
        int a=0;
        while(n>0){
            if(n%2==1){
                cnt++;
            }
            n=(int)n/2;
            
        }
        return cnt;
    }
}