class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        if not matrix or not matrix[0]:
            return matrix
        
        row = len(matrix)
        col = len(matrix[0])
        n = row if row < col else col
        for r in range(n + 1 >> 1):
            for c in range(n >> 1):
                tmp = matrix[r][c]
                matrix[r][c] = matrix[n - 1 - c][r]
                matrix[n - 1 - c][r] = matrix[n - 1 - r][n - 1 - c]
                matrix[n - 1 - r][n - 1 - c] = matrix[c][n - 1 - r]
                matrix[c][n - 1 - r] = tmp