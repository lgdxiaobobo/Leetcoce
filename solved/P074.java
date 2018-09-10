public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        else if (target < matrix[0][0]) return false;
        else if (target == matrix[0][0]) return true;
        
        int m, n;
        m = matrix.length;
        n = matrix[0].length;
        
        int row_l, row_r, row_m;
        int col_l, col_r, col_m;
        int remark_row;
        
        row_l = 0;
        row_r = m - 1;
        while(row_l < row_r){
            row_m = row_l + row_r >> 1;
            if (matrix[row_m][0] < target) row_l = row_m + 1;
            else if (matrix[row_m][0] > target) row_r = row_m - 1;
            else return true;
        }
        remark_row = row_l;
        if (matrix[remark_row][0] > target) remark_row --;
        
        col_l = 0;
        col_r = n - 1;
        while(col_l < col_r){
            col_m = col_l + col_r >> 1;
            if (matrix[remark_row][col_m] < target) col_l = col_m + 1;
            else if (matrix[remark_row][col_m] > target) col_r = col_m - 1;
            else return true;
        }
        
        
        return target == matrix[remark_row][col_l];
    }
}
