class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return []
        if len(nums) == 1:
            return nums[0]
        res = -float("INF")
        tmp = nums[0]
        for i in range(1, len(nums)):
            if tmp > res:
                res = tmp
            if tmp < 0:
                if nums[i] > tmp:
                    tmp = nums[i]
            else:
                if tmp + nums[i] > 0:
                    tmp += nums[i]
                else:
                    tmp = nums[i]
        if tmp > res:
            res = tmp
        return res