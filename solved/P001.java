import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] result = new int[2];
        
        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i ++){
            if (dict.containsKey(target - nums[i])){
                result[0] = dict.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            else dict.put(nums[i], i);
        }
        return result;
    }
}