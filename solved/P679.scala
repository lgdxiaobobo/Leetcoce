object Solution {

    val add: (Double, Double) => Double = (a, b) => a + b
    val minus: (Double, Double) => Double = (a, b) => a - b
    val mul: (Double, Double) => Double = (a, b) => a * b
    val div: (Double, Double) => Double = (a, b) => if (b != 0) a / b else 0
    val abs: Double => Double = a => if (a > 0) a else -a
    def canBeSolved(nums: Array[Double]): Boolean = {
        val n = nums.length
        // println(n)
        if (n == 1) abs(nums(0) - 24) < 0.00001
        else{
            val xy = for (ix <- 0 until n; iy <- 0 until n) yield (ix, iy)
            val all = (0 until n).toArray
            val ops = Array(add, minus, mul, div)
            xy.filter(p => p._1 != p._2).foldLeft(false){
                case (agg, (ix, iy)) => {
                    if (agg) agg
                    else{
                        val remains = all.filter(_ != ix).filter(_ != iy).map(nums.apply)
                        // remains.foreach(println)
                        ops.foldLeft(false)(
                            (agg, func) => {
                                if (!agg){
                                    val y = func(nums(ix), nums(iy))
                                    y > 0 && canBeSolved(remains :+ y)
                                }else agg
                            }
                        )
                    }
                }
            }
        }
    }

    def judgePoint24(nums: Array[Int]): Boolean = {
        canBeSolved(nums.map(_.toDouble))
    }
}