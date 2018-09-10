class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        N = len(nums)
        k = k % N

        x = 0
        y = N - k - 1
        while x < y:
            tmp = nums[x]
            nums[x] = nums[y]
            nums[y] = tmp
            x += 1
            y -= 1
        
        x = N - k
        y = N - 1
        while x < y:
            tmp = nums[x]
            nums[x] = nums[y]
            nums[y] = tmp
            x += 1
            y -= 1
        
        x = 0
        y = N - 1
        while x < y:
            tmp = nums[x]
            nums[x] = nums[y]
            nums[y] = tmp
            x += 1
            y -= 1
            