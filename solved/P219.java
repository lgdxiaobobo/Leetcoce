public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2) return false;
        HashMap<Integer, Integer> value_to_index = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i ++){
            if (value_to_index.containsKey(nums[i])){
                if (i - value_to_index.get(nums[i]) <= k){
                    return true;
                }
            }
            value_to_index.put(nums[i], i);
        }
        return false;
    }
}