package cn.zhangchg.leetcode.number;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 * <p>
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * @author 张晨刚
 */
public class IntegerToRoman {

    public static void main(String[] args) {
        System.err.println(intToRoman(3));
        System.err.println(intToRoman(4));
        System.err.println(intToRoman(9));
        System.err.println(intToRoman(58));
        System.err.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        Map<Integer, Character> map = new HashMap<>(16);
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
        StringBuilder sb = new StringBuilder();
        int flag = 1;
        while (num != 0) {
            int tempMultiple = num % 10;
            if(tempMultiple < 9 && tempMultiple >= 5){
                for (int i = 0; i < tempMultiple - 5; i++) {
                    sb.append(map.get(flag));
                }
                sb.append(map.get(flag * 5));
            }
            if (tempMultiple < 4) {
                for (int i = 0; i < tempMultiple; i++) {
                    sb.append(map.get(flag));
                }
            }
            if(tempMultiple == 4){
                sb.append(map.get(flag * 5));
                sb.append(map.get(flag));
            }
            if(tempMultiple == 9){
                sb.append(map.get(flag * 10));
                sb.append(map.get(flag));
            }
            num = num / 10;
            flag *= 10;
        }
        return sb.reverse().toString();
    }
}
