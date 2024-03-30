class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String s=String.valueOf(x);
        
        int _sum=0;
        for(int i=0; i<s.length(); i++){
            _sum+=Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        if(x%_sum==0){
            return true;
        }
        return false;
    }
}