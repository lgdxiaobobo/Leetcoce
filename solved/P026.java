public class Solution {
    public int removeDuplicates(int[] nums) {
        int result = 0;
        
        for (Integer x: nums){
            if (result == 0) nums[result ++] = x;
            else if (nums[result-1] < x){
                nums[result++] = x;
            }
        }
        
        return result;
    }
}