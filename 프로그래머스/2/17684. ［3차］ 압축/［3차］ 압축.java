import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> lst = new ArrayList<>();
        Map<String, Integer> dic = new HashMap<>();
        StringBuilder cur = new StringBuilder();
        StringBuilder last = new StringBuilder();
        cur.append(msg.charAt(0));
        
        // 처음 사전 초기화
        for(int i=0; i<26; i++){
            dic.put(Character.toString((char)('A' + i)), i+1);
        }
        
        int dicIdx =26;
        int idx=0;

        // 1. 첫글자 답에 추가, 첫글자 + 1 검색해보고 없으면 뒤에 추가, 있다면 없을 때까지 계속 +1. 제일 긴 문자열 답에 추가
        // 2. 두번째 글자 답에 추가, 두번째 글자 +1 해보고 없으면 뒤에 추가
        while(true){
            String temp = cur.toString();
            if(dic.containsKey(temp)){
                if(idx==msg.length()-1){
                    lst.add(dic.get(temp));    
                    break;
                }   
                else {
                    last = new StringBuilder(cur);
                    cur.append(msg.charAt(++idx));
                }
                continue;
            } else {
                // 없다면 -1한 문자열의 인덱스를 답에 추가
                lst.add(dic.get(last.toString()));                 
                // 그리고 없는 문자열을 딕셔너리에 추가
                dic.put(temp, ++dicIdx);
                // sb 초기화
                cur.setLength(0);
                cur.append(msg.charAt(idx));
            }
        }
        
        int[] answer = lst.stream().mapToInt(Integer::intValue).toArray();
        // System.out.println(lst);
        // int[] answer={};
        return answer;
    }
}