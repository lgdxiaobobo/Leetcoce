object Solution {
    def larger(s1: String, s2: String): Boolean = {
        s1.length > s2.length || (s1.length == s2.length && s1 < s2)
    }

    // def swap(arr: Array[String], l: Int, r: Int): Unit = {
    //     val tmp = arr(l)
    //     arr(l) = arr(r)
    //     arr(r) = tmp
    // }

    // def quickSort(arr: Array[String], l: Int, r: Int): Unit = {
    //     if (l + 1 == r){
    //         if (larger(arr(r), arr(l))) swap(arr, l, r)
    //     }else{
    //         var x = l
    //         var y = r
    //         val mid = arr(x + y >> 1)
    //         while (x < y){
    //             while (x < r && larger(arr(x), mid)) x += 1
    //             while (l < y && larger(mid, arr(y))) y -= 1
    //             if (x <= y){
    //                 swap(arr, x, y)
    //                 x += 1
    //                 y -= 1
    //             }
    //         }
    //         if (l < y) quickSort(arr, l, y)
    //         if (x < r) quickSort(arr, x, r)
    //     }
    // }

    def findLongestWord(s: String, d: List[String]): String = {
        val dLen = d.length
        val sLen = s.length
        if (dLen == 0 || sLen == 0) ""
        else{
            
            // quickSort(dict, 0, dLen - 1)
            d.foldLeft("")(
                (agg, x) => {
                    // if (agg.nonEmpty) agg
                    // else{
                    val xLen = x.length - 1
                    val hit = s.foldLeft(0)(
                        (idx, si) => 
                            if (idx > xLen) idx
                            else if (x(idx).equals(si)) idx + 1
                            else idx
                    )
                    if (hit > xLen && larger(x, agg)) x
                    else agg
                    // }
                }
            )
        }
    }
}