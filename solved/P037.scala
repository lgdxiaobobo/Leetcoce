object Solution {

    def search(lst: Array[(Int, Int, Int)], board: Array[Array[Char]], 
               row: Array[Array[Boolean]], col: Array[Array[Boolean]], 
               cell: Array[Array[Boolean]]): Boolean = {
        if (lst.isEmpty) true
        else{
            val (idx, idy, idz) = lst.head
            var flag = false
            for (cand <- 49 to 57){
                val y = cand - 49
                if (row(idx)(y) && col(idy)(y) && cell(idz)(y)){
                    board(idx)(idy) = cand.toChar
                    row(idx)(y) = false
                    col(idy)(y) = false
                    cell(idz)(y) = false
                    flag ||= search(lst.tail, board, row, col, cell)
                    if (!flag){
                        board(idx)(idy) = '.'
                        row(idx)(y) = true
                        col(idy)(y) = true
                        cell(idz)(y) = true
                    }
                }
            }
            flag
        }
    }

    def solveSudoku(board: Array[Array[Char]]): Unit = {
        val row = new Array[Array[Boolean]](9).map(lst => new Array[Boolean](9).map(x => true))
        val col = new Array[Array[Boolean]](9).map(lst => new Array[Boolean](9).map(x => true))
        val cell = new Array[Array[Boolean]](9).map(lst => new Array[Boolean](9).map(x => true))

        val index = for (idx <- 0 until 9; idy <- 0 until 9) yield (idx, idy, idx / 3 * 3 + idy / 3)
        val needAdd = index.toArray.foldLeft(Array[(Int, Int, Int)]()){
            case (agg, (idx, idy, idz)) => 
                if (board(idx)(idy) == '.') agg :+ (idx, idy, idz)
                else{
                    val x = board(idx)(idy) - '1'
                    row(idx)(x) = false
                    col(idy)(x) = false
                    cell(idz)(x) = false
                    agg
                }
        }

        search(needAdd, board, row, col, cell)
    }
}