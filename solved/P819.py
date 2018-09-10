class Solution(object):
    def mostCommonWord(self, paragraph, banned):
        """
        :type paragraph: str
        :type banned: List[str]
        :rtype: str
        """
        
        all_notatins = [x.lower() for x in paragraph.split(' ')]
        all_words = [x.strip("!?',;.") for x in all_notatins]
        valid_words = filter(lambda ch: ch not in set(banned), all_words)

        word_dct = {}
        for w in valid_words:
            if word_dct.has_key(w):
                word_dct[w] += 1
            else:
                word_dct[w] = 1

        res_w = ''
        res_cnt = 0
        for (w, cnt) in word_dct.items():
            if res_cnt < cnt:
                res_cnt = cnt
                res_w = w

        return res_w

