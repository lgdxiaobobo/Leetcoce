class Solution:
    def loudAndRich(self, richer, quiet):
        """
        :type richer: List[List[int]]
        :type quiet: List[int]
        :rtype: List[int]
        """
        r_size = len(richer)
        q_size = len(quiet)
        degree = [0 for idx in range(q_size)]
        edges  = {}
        for idx in range(r_size):
            x = richer[idx][0]
            y = richer[idx][1]
            degree[y] += 1
            if x not in edges:
                edges[x] = set([])
            edges[x].add(y)
            
        roots = [x for x in range(q_size) if degree[x] == 0]
        state = [[idx, quiet[idx]] for idx in range(q_size)]
        while len(roots) > 0:
            r = roots.pop(0)
            r_idx = state[r][0]
            r_val = state[r][1]
            if r in edges:
                for leaf in edges[r]:
                    if state[leaf][1] > r_val:
                        state[leaf] = [r_idx, r_val]
                    degree[leaf] = degree[leaf] - 1
                    if degree[leaf] == 0:
                        roots.append(leaf)
        return [x[0] for x in state]