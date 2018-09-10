class Solution:
    def numMagicSquaresInside(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        def match(mat):
            value = mat[0] + mat[1] + mat[2]
            less10 = set(filter(lambda x: x < 10 and x > 0, value))
            if len(less10) < 9:
                return False
            ref_sum = sum(mat[0])
            for idx in range(3):
                if sum(mat[idx]) != ref_sum:
                    return False
                if sum([mat[idx][y] for y in range(3)]) != ref_sum:
                    return False
            dig1 = sum([mat[x][x] for x in range(3)])
            dig2 = sum([mat[x][2-x] for x in range(3)])
            return ref_sum == dig1 and ref_sum == dig2
        
        n = len(grid)
        m = len(grid[0])
        cnt = 0
        for x in range(n - 2):
            for y in range(m - 2):
                sub = [[grid[x+dx][y+dy] for dy in range(3)] for dx in range(3)]
                if match(sub):
                    cnt += 1
        return cnt