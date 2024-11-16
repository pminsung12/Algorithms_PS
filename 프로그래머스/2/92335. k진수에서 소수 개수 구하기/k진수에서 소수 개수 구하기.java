import java.util.*;

class Solution {
    
    static List<String> lst = new ArrayList<>();
    static Map<Long, Boolean> primeMap = new HashMap<>();
    
    public int solution(int n, int k) {
        int answer = 0;
        changer(n, k);
        System.out.println(lst);
        for(int i=0; i<lst.size(); i++){
            if(isPrime(Long.parseLong(lst.get(i)))){
                answer++;
            }
        }
        return answer;
    }
    
    // 진수 변환
    static void changer(int n, int k){
        StringBuilder sb = new StringBuilder();
        String s;
        while((n/k)!=0){
            s = Integer.toString(n%k);
            if(s.equals("0")){
                if(sb.length() != 0){
                    lst.add(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.insert(0, s);
            }
            n/=k;
        }
        if(!Integer.toString(n).equals("0")) sb.insert(0, Integer.toString(n));
        if(sb.length() != 0){
            lst.add(sb.toString());
        }
        return;
    }
    
    // 소수 판별기
    static boolean isPrime(Long n){
        if(n==1) return false;
        if(primeMap.containsKey(n)){
            if(primeMap.get(n)){
                return true;
            }
            return false;
        }
        for(Long i=2L; i<=Math.sqrt(n); i++){
            if(n%i==0L){
                return false;
            }
        }
        primeMap.put(n, true);
        return true;
    }
    
    
}