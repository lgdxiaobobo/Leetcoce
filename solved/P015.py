class Solution:
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        res = []

        size = len(nums)

        state = {}
        for x in nums:
            if x not in state:
                state[x] = 0
            state[x] += 1
        print(state)
        for a in state.keys():
            for (b, cnt) in state.items():
                if a < b:
                    c = 0 - a - b
                    if c == b and cnt >= 2:
                            res.append([a, b, c])
                    elif b < c and c in state:
                        res.append([a, b, c])
                elif a == b and cnt >= 2:
                    c = 0 - a - b
                    if b < c and c in state:
                        res.append([a, b, c])
                    elif b == c and cnt >= 3:
                        res.append([a, b, c])

        return res