class RLEIterator(_A: Array[Int]) {
    
    var idx1 = 0
    var idx2 = 0

    def next(n: Int): Int = {
        val aLen = _A.length >> 1
        var curr = n
        while (idx1 < aLen && curr > 0){
            if (_A(idx1 << 1) == 0) idx1 += 1
            else{
                val r1 = _A(idx1 << 1) - idx2
                if (curr <= r1){
                    idx2 = idx2 + curr
                    curr = 0                
                }else{
                    curr -= r1
                    idx2 = 0
                    idx1 += 1
                }    
            }
        }        
        if (idx1 >= aLen) -1
        else _A((idx1 << 1) + 1)
    }

}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * var obj = new RLEIterator(A)
 * var param_1 = obj.next(n)
 */