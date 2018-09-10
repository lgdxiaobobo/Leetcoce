object Solution {

    def update(state: Array[Array[Boolean]], idx: Int, x: Char): Boolean = {
        if (x == '.') true
        else{
            val y = x - '1'
            if (state(idx)(y)) {
                state(idx)(y) = false
                true
            }
            else false
        }
    }

    def isValidSudoku(board: Array[Array[Char]]): Boolean = {

        val row = new Array[Array[Boolean]](9).map(_ => new Array[Boolean](9).map(x => true))
        val col = new Array[Array[Boolean]](9).map(_ => new Array[Boolean](9).map(x => true))
        val cell = new Array[Array[Boolean]](9).map(_ => new Array[Boolean](9).map(x => true))

        var flag = true

        for (idx <- 0 until 9; idy <- 0 until 9){
            val cid = idx / 3 * 3 + idy / 3
            val x = board(idx)(idy)
            flag &&= update(row, idx, x)
            flag &&= update(col, idy, x)
            flag &&= update(cell, cid, x)
        }
        flag        
    }
}