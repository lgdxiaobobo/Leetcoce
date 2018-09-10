class Solution(object):
    def largestSumOfAverages(self, A, K):
        """
        :type A: List[int]
        :type K: int
        :rtype: float
        """
        
        def ave(A, i0, i1):
            size = i1 - i0 + 1
            return (sum(A[i0:i1]) + A[i1]) * 1.0 / size
        
        N = len(A)
        b0 = [ave(A, 0, t) for t in xrange(N)]
        b1 = [0 for t in xrange(N)]
        for k in xrange(1, K):
            for i in xrange(k, N):
                b1[i] = 0
                for j in xrange(i):
                    b1[i] = max(b0[j] + ave(A, j + 1, i), b1[i])
            for i in xrange(N):
                b0[i] = b1[i]
        return b0[N-1]
            
                