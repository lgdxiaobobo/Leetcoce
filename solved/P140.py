class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        s_len = len(s)
        status = {}
        status[0] = []
        valid_seq = [0]
        valid_len = set([0])

        res = []
        def dfs(tmp, index):
            if index == 0:
                res.append(tmp)
            else:
                for word in status[index]:
                    dfs([word] + tmp, index - len(word))

        while len(valid_seq) > 0:
            ind = valid_seq.pop(0)
            for word in wordDict:
                if s[ind:].startswith(word):
                    length = ind + len(word)
                    if length not in valid_len:
                        valid_seq += [length]
                        valid_len.add(length)
                    if not status.has_key(ind + len(word)):
                        status[ind + len(word)] = set([])
                    status[ind + len(word)].add(word)

        if status.has_key(s_len):
            dfs([], s_len)
            return [" ".join(x) for x in res]
        else:
            return []