# 给定一个正整数，返回它在 Excel 表中相对应的列名称。
#
# 例如，
#
#     1 -> A
#    2 -> B
#    3 -> C
#    ...
#    26 -> Z
#    27 -> AA
#    28 -> AB
#    ...
#
#
# 示例 1:
#
# 输入: 1
# 输出: "A"
#
#
# 示例 2:
#
# 输入: 28
# 输出: "AB"
#
#
# 示例 3:
#
# 输入: 701
# 输出: "ZY"
#
#

class Solution:
    def convertToTitle2(self, n: int) -> str:
        letterArr = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                     "U", "V", "W", "X", "Y", "Z"]
        if n <= 26: return letterArr[n - 1]
        if n - 26 < 26 * 26:
            n -= 26
            return letterArr[int((n - 1) / 26)] + letterArr[n % 26 - 1]
        n -= 1
        return self.convertToTitle(int(n / 26)) + letterArr[n % 26]

    def convertToTitle(self, n: int) -> str:
        if n <= 0:
            return None
        numA = ord("A")
        res = ''
        while n // 26 > 0:
            res = chr((n - 1) % 26 + numA) + res
            n = (n - 1) // 26
        if n != 0:
            res = chr(n - 1 + numA) + res
        return res


s = Solution()
# print(s.convertToTitle(5))
# print(s.convertToTitle(28))
print(s.convertToTitle(52))
# print(s.convertToTitle(100))
print(s.convertToTitle(701))
print(s.convertToTitle(702))
print(s.convertToTitle(705))
print(s.convertToTitle(70511))
