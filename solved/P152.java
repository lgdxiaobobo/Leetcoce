public class Solution {
    public int max(int a, int b){
        return (a > b)? a: b;
    }
    
    public int min(int a, int b){
        return (a > b)? b: a;
    }
    
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int maxLast = nums[0];
        int minLast = nums[0];
        int maxCur  = 0;
        int minCur  = 0;
        int maxAll  = maxLast;
        
        for (int i = 1; i < nums.length; i ++){
            maxCur = max(nums[i], max(maxLast * nums[i], minLast * nums[i]));
            minCur = min(nums[i], min(maxLast * nums[i], minLast * nums[i]));
            maxLast= maxCur;
            minLast= minCur;
            maxAll = max(maxCur, maxAll);
        }
        return maxAll;
    }
}