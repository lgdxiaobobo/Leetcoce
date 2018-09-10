class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        x = 0
        y = 0
        for z in xrange(len(nums)):
            val = nums[z]
            nums[z] = 2
            if val < 2:
                nums[y] = 1
                y += 1
            if val == 0:
                nums[x] = 0
                x += 1