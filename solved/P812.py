class Solution(object):
    def largestTriangleArea(self, points):
        """
        :type points: List[List[int]]
        :rtype: float
        """
        
        def not_same(p, q):
            return not (p[0] == q[0] and p[1] == q[1])

        def cal_area(a, b, c):
            s1 = (b[0] - a[0]) * (c[1] - a[1])
            s2 = (b[1] - a[1]) * (c[0] - a[0])
            return 0.5 * abs(s1 - s2)

        best_area = 0.0

        for p1 in points:
            for p2 in points:
                for p3 in points:
                    if not_same(p1, p2) and not_same(p1, p3) and not_same(p2, p3):
                        area = cal_area(p1, p2, p3)
                        best_area = max(area, best_area)
        return best_area