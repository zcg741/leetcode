package cn.zhangchg.leetcode.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 张晨刚
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Interval {
    /**
     * 开始
     */
    int start;
    /**
     * 结束
     */
    int end;
}
