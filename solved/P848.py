class Solution:
    def shiftingLetters(self, S, shifts):
        """
        :type S: str
        :type shifts: List[int]
        :rtype: str
        """
        size = len(shifts)
        for idx in range(size-1,0,-1):
            shifts[idx-1] += shifts[idx]        
        return "".join([chr((ord(s) - 97 + t) % 26 + 97) for (s, t) in zip(S, shifts)])
