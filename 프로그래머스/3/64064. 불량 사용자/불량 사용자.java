import java.util.*;

class Solution {
    
    String[] bannedIds;
    String[] userIds;
    HashSet<HashSet<String>> result = new HashSet<>();
    
    void backtrack(HashSet<String> s, int depth){
        if (depth == bannedIds.length) {
            result.add(s);
            return;
        }
        
        for(int i=0; i<userIds.length; i++){
            if(s.contains(userIds[i])){
                continue;
            }
            
            if(check(userIds[i], bannedIds[depth])){
                s.add(userIds[i]);
                backtrack(new HashSet<>(s), depth+1);
                s.remove(userIds[i]);
            }
        }
    }
    
    boolean check(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        
        boolean isBanned = true;
        for(int i=0; i<a.length(); i++){
            if(b.charAt(i)!='*' && a.charAt(i) != b.charAt(i)){
                isBanned = false;
                break;
            }
        }
        return isBanned;
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        HashSet<String> set = new HashSet<>();
        userIds = user_id;
        bannedIds = banned_id;
        
        backtrack(new HashSet<>(), 0);
        
        
        return result.size();
    }
}