class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        if n == 0:
            return []

        res = []
        def search(tmp, cnt):
            if cnt == 0:
                res.append(tmp)
            else:
                for i in range(tmp[-1] + 1, n + 2 - cnt):
                    search(tmp + [i], cnt - 1)
        for x in range(1, n + 2 - k):
            search([x], k - 1)
        return res