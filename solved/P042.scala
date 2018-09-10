object Solution {
    def trap(height: Array[Int]): Int = {
        if (height.isEmpty) 0
        else{
            val fromLeft = height.foldLeft(Array[Int]())(
                (agg, x) => if (agg.isEmpty || agg.last < x) agg :+ x else agg :+ agg.last
            )
            val fromRight = height.foldRight(Array[Int]())(
                (x, agg) => if (agg.isEmpty || agg.head < x) x +: agg else agg.head +: agg
            )
            fromLeft.zip(fromRight).map(p => if (p._1 > p._2) p._2 else p._1)
                    .zip(height).map(p => p._1 - p._2).sum
        }
    }
}