import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        List<String> lst1 = new ArrayList<>();
        List<String> lst2 = new ArrayList<>();
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        // str1 부분집합 다 리스트에 저장
        for(int i=0; i<str1.length()-1; i++){
            if(!Character.isAlphabetic(str1.charAt(i)) || !Character.isAlphabetic(str1.charAt(i+1))){
                continue;
            }
            String s = str1.substring(i,i+2);
            lst1.add(s);
        }
        // str2 부분집합 다 리스트에 저장
        for(int i=0; i<str2.length()-1; i++){
            if(!Character.isAlphabetic(str2.charAt(i)) || !Character.isAlphabetic(str2.charAt(i+1))){
                continue;
            }
            String s = str2.substring(i,i+2);
            lst2.add(s);
        }
        int size2 = lst2.size();
        // 교집합 구하기
        int n=0;
        for(int i=0; i<lst1.size(); i++){
            for(int j=0; j<lst2.size(); j++){
                if(lst1.get(i).equals(lst2.get(j))){
                    lst2.remove(j);
                    n++;
                    break;
                }
            }
        }
        
        // set에 다 넣기
        // 합집합 수 = str1 + str2 - 교집합 수
        int u = lst1.size() + size2 - n;

        if(n==0 && u==0){
            return 65536;
        }
        // (int) 교집합 / 합집합 * 65536 
        double res = (double) n/u;
        answer = (int) (res * 65536);
        
        return answer;
    }
}