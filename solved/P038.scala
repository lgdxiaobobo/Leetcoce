object Solution {
    def getResult(n: Int, base: String): String = {
        if (n == 0) base
        else{
            val now = (base.tail + "0").foldLeft(("", base.head, 1))(
                (agg, x) => 
                    if (agg._2.equals(x)) (agg._1, agg._2, agg._3 + 1)
                    else (agg._1 + "%d%c".format(agg._3, agg._2), x, 1)
            )
            // println("%d,%s".format(n+5, now._1))
            getResult(n - 1, now._1)
        }
    }
    
    def countAndSay(n: Int): String = {
        n match {
            case 1 => "1"
            case 2 => "11"
            case 3 => "21"
            case 4 => "1211"
            case 5 => "111221"
            case _ => getResult(n-5, "111221")
        }
        
    }
}