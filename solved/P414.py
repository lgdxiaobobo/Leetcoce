class Solution(object):
    def thirdMax(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = set(nums)
        if len(nums) == 1:
            return max(nums)
        elif len(nums) == 2:
            return max(nums)
        else:
            for i in range(3):
                max_value = max(nums)
                nums.remove(max_value)
            return max_value