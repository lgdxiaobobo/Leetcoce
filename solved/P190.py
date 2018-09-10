class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        res = 0

        for i in range(32):
            print res, n
            res = (res << 1) + n % 2
            n = n >> 1

        return res