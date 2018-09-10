object Solution {
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
            if (l < y) quickSort(candidates, l, y)
            if (x < r) quickSort(candidates, x, r)
        }
    }

    def search(candidates: Array[Int], target: Int, path: List[Int]): List[List[Int]] = {
        if (target == 0) List(path)
        else{
            var result = List[List[Int]]()
            var last = -1
            for (ix <- 0 until candidates.length){
                val x = candidates(ix)
                val r = candidates.drop(ix + 1)
                if (last == -1 || x != last){
                    last = x
                    if (x <= target){
                        val temp = search(r, target - x, path :+ x)
                        if (temp.nonEmpty) result ++= temp
                    }
                }
            }
            result
        }
    }

    def combinationSum2(candidates: Array[Int], target: Int): List[List[Int]] = {
        val n = candidates.length
        quickSort(candidates, 0, n-1)
        // println(candidates.mkString(","))
        // List[List[Int]]()
        search(candidates, target, List[Int]())
    }
}