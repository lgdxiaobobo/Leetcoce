class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        if matrix and matrix[0]:
            rows = len(matrix)
            cols = len(matrix[0])

            exist_zero = lambda seq: len(seq) > 0 and (seq[0] == 0 or exist_zero(seq[1:]))
            for i in range(rows):
                if exist_zero(matrix[i]):
                    for j in range(cols):
                        if matrix[i][j] != 0:
                            matrix[i][j] = ""

            for j in range(cols):
                flag = False
                for i in range(rows):
                    if matrix[i][j] == 0:
                        flag = True
                        break
                if flag:
                    for i in range(rows):
                        if matrix[i][j] != 0:
                            matrix[i][j] = ""

            for i in range(rows):
                for j in range(cols):
                    if matrix[i][j] == "":
                        matrix[i][j] = 0