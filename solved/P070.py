class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 0:
            return 0
        elif n == 1:
            return 1
        elif n == 2:
            return 2
        else:
            a = 1
            b = 2
            while n >= 3:
                c = a + b
                a = b
                b = c
                n = n - 1
            return c