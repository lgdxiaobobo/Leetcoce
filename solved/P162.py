class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) <= 1:
            return 0
        
        def is_peak(nums, ind):
            if ind == 0:
                return nums[ind] > nums[ind+1]
            elif ind == len(nums) - 1:
                return nums[ind] > nums[ind - 1]
            else:
                return nums[ind] > nums[ind - 1] and nums[ind] > nums[ind + 1]
        
        left = 0
        right = len(nums) - 1
        while left + 1 < right:
            m1 = left + right >> 1
            m2 = m1 + 1
            if nums[m1] < nums[m2]:
                left = m2
            else:
                right = m1
        while not is_peak(nums, left):
            left += 1
        
        return left