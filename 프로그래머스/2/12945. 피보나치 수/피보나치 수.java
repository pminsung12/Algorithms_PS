class Solution {
    static int[] arr= new int[100001];
    
    public int solution(int n) {
        int answer = 0;
        arr[0]=0;
        arr[1]=1;
        int a=2;
        while(a<=n){
            arr[a]=(arr[a-1]+arr[a-2])%1234567;
            a++;
        }
        
        return arr[n];
    }
 
}