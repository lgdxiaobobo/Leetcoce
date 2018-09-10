public class Solution {
    public int removeDuplicates(int[] nums) {
        int result = 0;
        for (Integer x: nums){
            if (result < 2) nums[result++] = x;
            else if (nums[result-2] < x) nums[result ++] = x;
        }
        return result;
    }
}