object Solution {
    def minimum(S: String): String = {
        val zeroCont = Map[Char, Int]()
        val charCont = S.foldLeft(zeroCont)((agg, x) => {
            val y = agg.getOrElse(x, 0) + 1
            agg + (x -> y)
        })
        var resultS = ""
        for (ch <- 'a' to 'z'){
            if (charCont.contains(ch)){
                for (cnt <- 0 until charCont(ch)){
                    resultS += ch
                }
            }
        }
        resultS
    }
    def orderlyQueue(S: String, K: Int): String = {
        if (S.length <= 1) S
        else{
            if (K >= 2) minimum(S)
            else{
                var minS = S
                var tmpS = S
                for (i <- 1 until S.length){
                    tmpS = tmpS.tail + tmpS.head
                    if (tmpS < minS){
                        minS = tmpS
                    }
                }
                minS
            }
        }
    }
}