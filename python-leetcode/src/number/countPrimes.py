# 统计所有小于非负整数 n 的质数的数量。
#
# 示例:
#
# 输入: 10
# 输出: 4
# 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
#
#
from math import sqrt


class Solution:

    def countPrimes(self, n: int) -> int:
        if n < 3:
            return 0
        else:
            # 首先生成了一个全部为1的列表
            output = [1] * n
            # 因为0和1不是质数,所以列表的前两个位置赋值为0
            output[0], output[1] = 0, 0
            # 此时从index = 2开始遍历,output[2]==1,即表明第一个质数为2,然后将2的倍数对应的索引
            # 全部赋值为0. 此时output[3] == 1,即表明下一个质数为3,同样划去3的倍数.以此类推.
            for i in range(2, int(n ** 0.5) + 1):
                if output[i] == 1:
                    output[i * i:n:i] = [0] * len(output[i * i:n:i])
        # 最后output中的数字1表明该位置上的索引数为质数,然后求和即可.
        return sum(output)

    def countPrimes1(self, n: int) -> int:
        if n < 2: return 0
        flag = 0
        flagN = 2
        while flagN < n:
            if self.checkPrime(flagN):
                flag += 1
            flagN += 1
        return flag

    def checkPrime(self, flagN: int) -> bool:
        if flagN < 3: return True
        if flagN % 2 == 0: return False
        flag = 3
        floatFlag = sqrt(float(flagN)) + 1
        while flag <= floatFlag:
            if flagN % flag == 0: return False;
            flag += 1
        return True


s = Solution()
count = s.countPrimes(10000)
print(count)
