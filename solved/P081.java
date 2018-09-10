public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length < 0) return false;
        if (nums.length == 1) return nums[0] == target;
        else{
            boolean result = false;
            for (int i = 0; i < nums.length; i ++){
                if (nums[i] == target) {
                    result = true;
                    break;
                }
            }
            
            return result;
        }
    }
}