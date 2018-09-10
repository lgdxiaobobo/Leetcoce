class Solution(object):
    def consecutiveNumbersSum(self, N):
        """
        :type N: int
        :rtype: int
        """
        if N == 1:
            return 1
        else:
            kids = set([])
            x = 1
            while x * x / 2 <= N:
                if N % x == 0:
                    y = N // x                       
                    if x % 2 == 1:
                        kids.add(x)
                    if y % 2 == 1:
                        kids.add(y)
                elif (N * 2) % x == 0:
                    if x % 2 == 0:
                        kids.add(x)
                    y = (N * 2) // x
                    if y % 2 == 0:
                        kids.add(y)
                x += 1
            res = 0
            for x in list(kids):
                if x % 2 == 1:
                    z = N // x
                    g = x >> 1
                    if z > g:
                        res += 1
                else:
                    z0 = N // x
                    g  = (x >> 1) - 1
                    if z0 > g:
                        res += 1                     
                    
            return res
                