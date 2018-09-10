class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if not nums:
            return nums
        n = len(nums)
        res = []
        def cons(seq, remain):
            if remain == 0:
                res.append(seq)
            else:
                for i in range(seq[-1]+1, n + 1 - remain):
                    cons(seq + [i], remain - 1)
        for size in range(n+1):
            if size == 0:
                res.append([])
            else:
                for x in range(n-size+1):
                    cons([x], size-1)
        return [[nums[x] for x in t] for t in res]