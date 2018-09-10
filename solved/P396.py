class Solution(object):
    def maxRotateFunction(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        if len(A) <= 1:
            return 0
            
        N = len(A)
        sigma = reduce(lambda a, b: a + b, A)
        
        res = 0
        for i in range(N):
            res += i * A[i]
        
        f0 = res
        for i in range(N-1):
            f0 += N * A[i] - sigma
            if f0 > res:
                res = f0
        
        return res