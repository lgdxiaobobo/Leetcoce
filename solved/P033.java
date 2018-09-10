public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length < 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        else{
            int result = -1;
            int l = 0;
            int r = nums.length - 1;
            while(l < r){
                
                int m = l + r >> 1;
            
                if (nums[m] == target){
                    result = m;
                    break;
                }
                
                if (nums[l] == target){
                    result = l;
                    break;
                }
                
                if (nums[r] == target){
                    result = r;
                    break;
                }
                if (l + 1 >= r) break;
                
                if (nums[l] < nums[r]){
                    if (nums[r] < target) break;
                    else if (nums[l] > target) break;
                    else{
                        if (nums[m] > target) r = m -1;
                        else l = m + 1;
                    }
                }
                else{
                    if (target < nums[l] && target > nums[r]) break;
                    if (nums[m] > nums[l]){
                        if (target > nums[l] && target < nums[m]) r = m - 1;
                        else l = m + 1;
                    }
                    else{
                        if (target > nums[l] || target < nums[m]) r = m -1;
                        else l = m + 1;
                    }
                }
            }
            return result;
        }
    }
}