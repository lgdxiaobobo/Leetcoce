class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if not nums:
            return nums
        nums.sort()
        n = len(nums)
        res = []
        exist = set([])
        def cons(seq, remain):
            if remain == 0:
                tmp = ",".join([str(nums[x]) for x in seq])
                if tmp not in exist:
                    exist.add(tmp)
                    res.append(map(int, tmp.split(",")))
            else:
                for i in range(seq[-1]+1, n + 1 - remain):
                    cons(seq + [i], remain - 1)
        for size in range(n+1):
            if size == 0:
                res.append([])
            else:
                for x in range(n-size+1):
                    cons([x], size-1)
        return res