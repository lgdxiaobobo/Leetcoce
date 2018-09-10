class Solution(object):
    def allPathsSourceTarget(self, graph):
        """
        :type graph: List[List[int]]
        :rtype: List[List[int]]
        """
        N = len(graph)
        src = 0
        dst = N - 1

        seq = [[src]]
        result = []
        while len(seq) > 0:
            head = seq.pop(0)
            last_node = head[-1]
            for next_node in graph[last_node]:
                path = head + [next_node]
                if next_node == dst:
                    result.append(path)
                else:
                    seq.append(path)
        
        return result
