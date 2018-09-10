object Solution {
    def getAllValues(A: Array[Int]): (Set[Int], Set[Int], Set[Int], Int) = {
        val n = A.length
        if (n == 0) (Set[Int](), Set[Int](), Set[Int](), 0)
        else if (n == 1) (Set(A(0)), Set(A(0)), Set(A(0)), A(0))
        else{
            val half = n >> 1
            val A1 = A.take(half)
            val A2 = A.drop(half)
            val (c1, l1, r1, a1) = getAllValues(A1)
            val (c2, l2, r2, a2) = getAllValues(A2)
            val c0 = c1 ++ c2
            val l0 = l2.foldLeft(l1)((agg, x) => agg + (a1 | x))
            val r0 = r1.foldLeft(r2)((agg, x) => agg + (a2 | x))
            val ctmp = for (x <- r1; y <- l2) yield x | y
            val cache = ctmp.foldLeft(c0)((agg, x) => agg + x)
            // println(c1.mkString("|"), l1.mkString("|"), r1.mkString("|"), A1.mkString("|"))
            // println(c2.mkString("|"), l2.mkString("|"), r2.mkString("|"), A2.mkString("|"))
            // println(cache.mkString("|"), l0.mkString("|"), r0.mkString("|"), A.mkString("|"))
            (cache, l0, r0, a1 | a2)
        }

    }

    def subarrayBitwiseORs(A: Array[Int]): Int = {
        if (A.isEmpty) 0
        else if (A.length == 1) 1
        else{
            getAllValues(A)._1.size
        }
    }
}