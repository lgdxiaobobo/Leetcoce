class Solution(object):
    def rotateString(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: bool
        """
        if len(A) != len(B):
            return False
        else:
            flag = False
            for k in xrange(len(A)):
                C = A[k:] + A[0:k]
                if C == B:
                    flag = True
                    break
            return flag