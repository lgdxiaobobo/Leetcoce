class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        n = len(triangle)
        for h in range(n-2, -1, -1):
            for w in range(h + 1):
                triangle[h][w] += min(triangle[h+1][w], triangle[h+1][w+1])
        return triangle[0][0]