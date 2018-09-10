object Solution {
    def isMonotonic(A: Array[Int]): Boolean = {
        if (A.length <= 1) true
        else{
            val delta = A(1) - A(0)
            A.tail.foldLeft((true, delta, A(1)))(
                (agg, x) => {
                    // println(agg._1, agg._2, agg._3)
                    val diff = x - agg._3
                    val state = agg._1 && (diff * agg._2 >= 0)
                    if (diff != 0) (state, diff, x)
                    else (state, agg._2, x)
                }
            )._1
        }
    }
}