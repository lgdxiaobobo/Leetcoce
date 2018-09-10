object Solution {
    
    def findLeft(nums: Array[Int], left: Int, right: Int, x: Int): Int = {
        if (left + 1 >= right){
            if (nums(left) == x) left
            else if (nums(right) == x) right
            else -1
        }else{
            val middle = left + right >> 1
            if (nums(middle) < x) findLeft(nums, middle, right, x)
            else findLeft(nums, left, middle, x)
        }
    }
    
    def findRight(nums: Array[Int], left: Int, right: Int, x: Int): Int = {
        if (left + 1 >= right){
            if (nums(right) == x) right
            else if (nums(left) == x) left
            else -1
        }else{
            val middle = left + right >> 1
            if (nums(middle) > x) findRight(nums, left, middle, x)
            else findRight(nums, middle, right, x)
        }
    }
    
    def searchRange(nums: Array[Int], target: Int): Array[Int] = {
        if (nums.isEmpty) Array(-1, -1)
        else{
            val n = nums.length - 1
            val i1 = findLeft(nums, 0, n, target)
            if (i1 == -1){
                Array(-1, -1)
            }else{
                val i2 = findRight(nums, 0, n, target)    
                Array(i1, i2)
            }    
        }
    }
}