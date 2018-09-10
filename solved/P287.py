class Solution(object):
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0: 
            return -1;

        count_l = lambda x, low: len(filter(lambda p: p < x and p >= low, nums))
        count_g = lambda x, high: len(filter(lambda p: p > x and p <= high, nums))
        is_equal = lambda x: len(filter(lambda p: p == x, nums)) > 1

        low = min(nums)
        high= max(nums)
        while low < high:
            mid = low + high >> 1
            if is_equal(mid):
                return mid
            cnt_l = count_l(mid, low)
            cnt_g = count_g(mid, high)
            if cnt_l < cnt_g:
                low = mid + 1
            else:
                high = mid - 1

        while not is_equal(low):
            low += 1
        return low