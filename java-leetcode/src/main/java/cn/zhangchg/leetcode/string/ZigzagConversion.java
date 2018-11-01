package cn.zhangchg.leetcode.string;


/**
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 * <p>
 * 实现一个将字符串进行指定行数变换的函数:
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "PAYPALISHIRING", numRows = 3
 * 输出: "PAHNAPLSIIGYIR"
 * 示例 2:
 * <p>
 * 输入: s = "PAYPALISHIRING", numRows = 4
 * 输出: "PINALSIGYAHRPI"
 * 解释:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * @author 张晨刚
 */
public class ZigzagConversion {

    public static void main(String[] args) {
        System.err.println(convert("PAYPALISHIRING", 3));
        //System.err.println(convert("AB", 1));
    }

    /**
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n){
                    ret.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return ret.toString();
    }

    /**
     * 复杂度O(len(N))
     * @param s
     * @param numRows
     * @return
     */
    public static String convert2(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int flag = 0, zFlag = 0;
        char[][] ints = new char[s.length() / 2 + 1][numRows];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ints.length; i++) {
            for (int j = ints[i].length - 1; j >= 0; j--) {
                if (flag >= s.length()) {
                    break;
                }
                if (zFlag == j || zFlag == 0 || zFlag == ints[i].length - 1) {
                    ints[i][j] = s.charAt(flag++);
                }
            }
            zFlag += 1;
            if (zFlag > ints[i].length - 1) {
                zFlag = 1;
            }
        }
        for (int j = ints[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < ints.length; i++) {
                if ('\u0000' != ints[i][j]) {
                    sb.append(ints[i][j]);
                }
            }
        }
        return sb.toString();
    }
}
