object Solution {

    def twoMatch(x: Long, y: Long, num: String): Boolean = {
        if (num.length < 1) false
        else{
            val z = x + y
            if (num.head == '0') z == 0 && (num.length == 1 || twoMatch(y, 0, num.tail))
            else{
                // println(x, y, z)
                val zStr = z.toString
                val zLen = zStr.length
                num.startsWith(zStr) && (num.length == zLen || twoMatch(y, z, num.drop(zLen)))
            }
        }
    }

    def oneMatch(x: Long, num: String): Boolean = {
        if (num.length < 2) false
        else{
            num.head match {
                case '0' => twoMatch(x, 0, num.tail)
                case _ => {
                    var state = false
                    var arr = num
                    var y = 0L
                    while (!state && arr.length > 0){
                        y = y * 10 + arr.head - '0'
                        arr = arr.tail
                        state = twoMatch(x, y, arr)
                    }
                    state
                }
            }
        }
    }

    def isAdditiveNumber(num: String): Boolean = {
        if (num.length < 3) false
        else{
            num.head match {
                case '0' => oneMatch(0, num.tail)
                case _ => {
                    var state = false
                    var arr = num
                    var x = 0
                    while (!state && arr.length > 0){
                        x = x * 10 + arr.head - '0'
                        arr = arr.tail
                        state = oneMatch(x, arr)
                    }
                    state
                }
            }
        }
    }
} 