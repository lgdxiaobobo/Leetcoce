class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        
        def xor(nums):
            return reduce(lambda a, b: a ^ b, nums)

        flag = xor(nums)
        part1 = filter(lambda x: x < x ^ flag, nums)
        part2 = filter(lambda x: x >= x ^ flag, nums)
        
        return [xor(part1), xor(part2)]