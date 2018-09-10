class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        
        if not matrix or not matrix[0]:
            return False

        m = len(matrix)
        n = len(matrix[0])

        flag = False
        for i in range(m):
            if matrix[i][0] <= target or matrix[i][n-1] >= target:
                l = 0
                r = n - 1
                while l + 1 < r:
                    m = l + r >> 1
                    if matrix[i][m] == target:
                        return True
                    elif matrix[i][m] > target:
                        r = m -1
                    else:
                        l = m + 1
                while l < n and matrix[i][l] < target:
                    l += 1
                if l == n:
                    l = n - 1
                if matrix[i][l] == target:
                    return True
        return False