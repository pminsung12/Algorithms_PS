import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answerList = new ArrayList<>();
        Map<String, Integer> total = new HashMap<>();
        Map<String, TreeMap<Integer, Integer>> genreMap = new HashMap<>();
        
        // 순회하며 total 맵에 장르별 총 판매량 업데이트
        for(int i=0; i<genres.length; i++){
            total.put(genres[i], total.getOrDefault(genres[i],0)+plays[i]);
            genreMap
                .computeIfAbsent(genres[i], k -> new TreeMap<>((a, b) -> {
                    if (plays[a] == plays[b]) {
                        return a - b;
                    } else {
                        return plays[b] - plays[a];
                    }
                }))
                .put(i, plays[i]);
        }
        
        // 가장 판매량이 높은 장르부터 오름차순 정렬
        List<String> genreList = new ArrayList<>(total.keySet());
        genreList.sort((a,b)->total.get(b)-total.get(a));
        
        // 장르별로 많이 재생된 노래 최대 2개 씩 answer에 추가
        for(String s: genreList){
            TreeMap<Integer, Integer> treeMap = genreMap.get(s);
            int cnt=0;
            for(int idx: treeMap.keySet()){
                if(cnt>=2) break;
                answerList.add(idx);
                cnt++;
            }
        }
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}