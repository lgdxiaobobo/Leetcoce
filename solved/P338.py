class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        res = []

        def countBit(x):
            cnt = 0
            while x > 0:
                cnt += x % 2
                x = x >> 1
            return cnt

        for x in range(num+1):
            res.append(countBit(x))

        return res