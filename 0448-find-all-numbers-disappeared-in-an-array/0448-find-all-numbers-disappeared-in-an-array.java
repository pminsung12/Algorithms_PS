class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> lst = new ArrayList<>();

        for (int i : nums) {
            set.add(i);
        }

        for(int i=1; i<=nums.length; i++){
            if(set.contains(i)){
                continue;
            } else {
                lst.add(i);
            }
        }

        return lst;
    }
}