class Solution(object):
    def largestDivisibleSubset(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        
        if not nums:
            return nums

        nums.sort()
        n = len(nums)
        res = [[1, [nums[x]]] for x in range(n)]

        for i in range(n):
            index = i - 1
            flag = False
            while index >= 0:
                if nums[i] % nums[index] == 0 and res[index][0] >= res[i][0]:
                    res[i][0] = res[index][0] + 1
                    res[i][1] = res[index][1] + [nums[i]]
                index -= 1

        best = []
        for i in range(n):
            if len(best) < res[i][0]:
                best = res[i][1]

        return best