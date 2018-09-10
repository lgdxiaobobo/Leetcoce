object Solution {

    def dfs(target: Int, path: List[Int], candidates: Array[Int]): List[List[Int]] = {
        if (target == 0){
            List(path)
        }else{
            var result = List[List[Int]]()
            for (idx <- 0 until candidates.length){
                val x = candidates(idx)
                val r = candidates.drop(idx)
                if (x <= target){
                    val next = dfs(target - x, path :+ x, r)
                    if (next.nonEmpty) result ++= next
                }
            }
            result
        }
    }


    def swap(candidates: Array[Int], i: Int, j: Int): Unit = {
        val temp = candidates(i)
        candidates(i) = candidates(j)
        candidates(j) = temp
    }

    def swapIfExist(candidates: Array[Int], i: Int, j: Int): Unit = {
        if (candidates(i) > candidates(j)) swap(candidates, i, j)
    }

    def quickSort(candidates: Array[Int], l: Int, r: Int): Unit = {
        if (l + 1 == r) swapIfExist(candidates, l, r)
        else if (l < r){
            val m =  candidates(l + r >> 1)
            var x = l
            var y = r
            while (x < y){
                while (x < r && candidates(x) < m) x += 1
                while (y > l && candidates(y) > m) y -= 1
                if (x < y){
                    swap(candidates, x, y)
                    x += 1
                    y -= 1
                }
            }
            if (l < x) quickSort(candidates, l, x)
            if (y < r) quickSort(candidates, y, r)
        }
    }

    def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
        val n = candidates.length
        quickSort(candidates, 0, n - 1)
        dfs(target, List[Int](), candidates)
    }
}