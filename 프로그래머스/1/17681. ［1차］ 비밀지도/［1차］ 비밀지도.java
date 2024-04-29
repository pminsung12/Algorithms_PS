class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            String row = "";
            String s1 = Integer.toBinaryString(arr1[i]);
            String s2 = Integer.toBinaryString(arr2[i]);
            
            String[] s1_b = addZero(s1,n);
            String[] s2_b = addZero(s2,n);
            
            for(int j=0; j<n; j++){
                if("1".equals(s1_b[j]) || "1".equals(s2_b[j])){
                    row+="#";
                    continue;
                }
                row+=" ";
            }
            answer[i]=row;
            
        }
    
        return answer;
    }
    
    static String[] addZero(String s, int n){
        String zero = "";
        if (s.length()<n){
            for(int i=0; i<n-s.length(); i++){
                zero+="0";
            }
        }
        s=zero+s;
        
        return s.split("");
    }
}