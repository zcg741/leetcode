# 编写一个算法来判断一个数是不是“快乐数”。
#
# 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为
# 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
#
# 示例:
#
# 输入: 19
# 输出: true
# 解释:
# 12 + 92 = 82
# 82 + 22 = 68
# 62 + 82 = 100
# 12 + 02 + 02 = 1
#
#

class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        record = []
        sq_sum = 0
        se_n = n

        while se_n != 1:
            sq_sum = 0
            while se_n > 0:
                sq_sum += (se_n % 10) * (se_n % 10)
                se_n = se_n / 10
            if sq_sum in record:
                return False
            record.append(sq_sum)
            se_n = sq_sum

        return True

    def isHappy1(self, n):
        """
        :type n: int
        :rtype: bool
        """
        nStr = str(n)
        length = len(nStr)
        sum = 0
        i = 0
        while i < length:
            flag = int(nStr[i])
            sum += flag * flag
            i += 1

        if sum == 1:
            return True
        else:
            if sum == 4:
                return False
            else:
                return self.isHappy1(sum)


s = Solution()
isHappy1 = s.isHappy(19)
print(isHappy1)
