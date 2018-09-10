public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> store = new HashSet<Integer>();
        boolean flag = false;
        for (Integer x: nums){
            if (store.contains(x)) return true;
            else {
                store.add(x);
            }
        }
        return flag;
    }
}