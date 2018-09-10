class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return nums[0]
        
        a = 0
        b = 0
        c = 0
        
        for x in nums:
            c = b & x
            b = b | (a & x)
            a = a ^ (x & ~b)
            b = b & ~c
            a = a & ~c
        return a