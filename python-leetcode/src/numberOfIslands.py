# 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
# 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
#
# 示例 1:
#
# 输入:
# 11110
# 11010
# 11000
# 00000
#
# 输出: 1
#
#
# 示例 2:
#
# 输入:
# 11000
# 11000
# 00100
# 00011
#
# 输出: 3
#
#

visited = []
class Solution(object):
    def dfs(self, grid, i, j):
        """
        :type grid: List[List[str]]
        :type i:int
        :type j:int
        """
        if i >= 0 and i < len(grid) and j >= 0 and j < len(grid[0]):
            if not visited[i][j] and grid[i][j] == '1':
                visited[i][j] = True
                self.dfs(grid, i - 1, j)
                self.dfs(grid, i + 1, j)
                self.dfs(grid, i, j + 1)
                self.dfs(grid, i, j - 1)

    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        global visited
        visited = []
        if len(grid) == 0: return 0
        res = 0
        i = 0
        while i < len(grid):
            j = 0
            visited1 = []
            while j < len(grid[i]):
                visited1.append(False)
                j += 1
            visited.append(visited1)
            i += 1
        i = 0
        while i < len(grid):
            j = 0
            while j < len(grid[i]):
                if grid[i][j] == "1" and not visited[i][j]:
                    res += 1
                    self.dfs(grid, i, j)
                j += 1
            i += 1
        return res


s = Solution()
num = s.numIslands([["1", "0", "1", "1", "0", "1", "1"]])
print(num)
num = s.numIslands([["1", "1", "1", "1", "0"],
                    ["1", "1", "0", "1", "0"],
                    ["1", "1", "0", "0", "0"],
                    ["0", "0", "0", "1", "1"]])
print(num)
