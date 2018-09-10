class Solution(object):
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if not nums or len(nums) == 1:
            return False

        sigma = sum(nums)
        if sigma % 2 == 1:
            return False

        part = sigma / 2
        status = {0:True}
        n = len(nums)
        for i in range(n):
            for w in status.keys():
                if w + nums[i] <= part:
                    status[w + nums[i]] = True
        return part in status