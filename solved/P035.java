object Solution {
    def findPosition(nums: Array[Int], l: Int, r: Int, x: Int): Int = {
        if (l + 1 < r){
            val m = l + r >> 1
            if (nums(m) == x) m
            else if (nums(m) > x) findPosition(nums, l, m, x)
            else findPosition(nums, m, r, x)
        }
        else{
            if (nums(l) >= x) l
            else r
        }
    }
    def searchInsert(nums: Array[Int], target: Int): Int = {
        if (nums.isEmpty) 0
        else if (target  < nums.head) 0
        else if (target > nums.last) nums.length
        else{
            val n = nums.length
            val pos = findPosition(nums, 0, n-1, target)    
            pos
        }        
    }
}