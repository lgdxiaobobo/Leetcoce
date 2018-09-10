class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        N = len(height)
        l = 0
        r = N - 1
        res = 0
        while l < r:
            area = min(height[l], height[r]) * (r - l)
            if area > res:
                res = area
            if height[l] < height[r]:
                l += 1
            else:
                r -= 1
        return res
                
        