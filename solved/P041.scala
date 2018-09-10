object Solution {

    def swap(nums: Array[Int], ix: Int, iy: Int): Unit = {
        val tmp = nums(ix)
        nums(ix) = nums(iy)
        nums(iy) = tmp
    }

    def firstMissingPositive(nums: Array[Int]): Int = {
        if (nums.isEmpty) 1
        else{
            val minimum = nums.min
            if (minimum > 1) 1
            else{
                val n = nums.length
                val index = (1 to n).toArray
                index.foreach(idx => {
                    while(nums(idx-1) != idx && nums(idx-1) > 0 && nums(idx-1) <= n && nums(idx-1) != nums(nums(idx-1)-1)){
                        swap(nums, nums(idx-1)-1, idx-1)
                    }
                })
                index.foldLeft(n+1)((agg, x) => if (x <= agg && nums(x-1) != x) x else agg)
            }
        }
    }
}