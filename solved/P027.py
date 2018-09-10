class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        n = len(nums)
        cnt = 0
    
        for i in range(n):
            if nums[i] != val:
                nums[cnt] = nums[i]
                cnt += 1
        return cnt