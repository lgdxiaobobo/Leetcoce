class Solution(object):
    def findLadders(self, begin_word, end_word, word_lst):
        """
        :type begin_word: str
        :type end_word: str
        :type word_lst: Set[str]
        :rtype: List[List[int]]
        """

        inf  = float("inf")
        if begin_word == end_word:
            return [[begin_word, end_word]]

        def get_path_link(word, word_lst):
            link_status = set([])    
            for l in range(len(word)):
                for ch in range(26):
                    tmp = word[:l] + chr(97 + ch) + word[l+1:]
                    if tmp in word_lst:
                        link_status.add(tmp)
            return link_status
        
        def get_min_deep(begin_word, end_word, word_lst):
            path  = {}
            visit = set([])
            update= set([])

            word_lst.add(begin_word)
            word_lst.add(end_word)

            for word in word_lst:
                path[word] = set([])

            visit.add(begin_word)
            word_lst.remove(begin_word)

            while len(visit) > 0:
                for word in visit:
                    linked_word = get_path_link(word, word_lst)
                    for other in linked_word:
                        if other not in update:
                            update.add(other)
                        path[other].add(word)
                if end_word in update:
                    break
                visit = update
                word_lst -= update
                update = set([])

            return path
        
        def dfs(word, trans_lst):
            if len(path[word]) == 0:
                if word == begin_word:
                    res_trans_path.append(trans_lst)
            else:
                for w in path[word]:
                    dfs(w, [w] + trans_lst)

        path = get_min_deep(begin_word, end_word, word_lst)

        if not path.has_key(end_word):
            return []
        else:
            res_trans_path = []
            dfs(end_word, [end_word])
            return res_trans_path