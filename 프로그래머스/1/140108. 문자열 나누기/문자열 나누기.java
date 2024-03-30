class Solution {
    public int solution(String s) {
        int answer = 0;
        char start=' ';
        int s_cnt=0, other_cnt=0;
        for(int i=0;i<s.length();i++){
            if(start==' '){
                start=s.charAt(i);
                s_cnt=1;
                continue;
            }
            if(start==s.charAt(i)){
                s_cnt+=1;
            }else{
                other_cnt+=1;
            }
            if(s_cnt==other_cnt){
                answer+=1;
                s_cnt=0;
                other_cnt=0;
                start=' ';
            }
        }
        if(s_cnt!=other_cnt) answer+=1;
        
        
        return answer;
    }
}