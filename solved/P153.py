class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        N = len(nums)
        if N == 0:
            return None
        if N == 1:
            return nums[0]
        l = 0
        r = N - 1
        while l + 1 < r:
            m = l + r >> 1
            if nums[l] > nums[r]:
                if nums[m] < nums[r]:
                    r = m
                else:
                    l = m + 1
            else:
                break
        res = nums[l]
        while l < N and res >= nums[l]:
            res = nums[l]
            l += 1
        return res