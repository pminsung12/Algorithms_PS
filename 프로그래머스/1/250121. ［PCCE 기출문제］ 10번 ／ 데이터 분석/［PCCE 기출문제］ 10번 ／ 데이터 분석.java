import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        Map<String, Integer> idxMap = new HashMap<>();
        idxMap.put("code",0);
        idxMap.put("date",1);
        idxMap.put("maximum",2);
        idxMap.put("remain",3);
        
        int[][] arr = Arrays.stream(data).filter(x->x[idxMap.get(ext)]<val_ext).toArray(int[][]::new);
        Arrays.sort(arr, (a,b)->a[idxMap.get(sort_by)]-b[idxMap.get(sort_by)]);

        return arr;
    }
}