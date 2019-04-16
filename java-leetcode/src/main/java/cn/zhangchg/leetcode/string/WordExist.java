package cn.zhangchg.leetcode.string;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 * @author 张晨刚
 */
public class WordExist {
    public static void main(String[] args) {
        WordExist wordExist = new WordExist();
        char[][] chars = new char[3][4];
        chars[0] = new char[]{'A', 'B', 'C', 'E'};
        chars[1] = new char[]{'S', 'F', 'C', 'S'};
        chars[2] = new char[]{'A', 'D', 'E', 'E'};
        System.err.println(wordExist.exist(chars, "ABCCED"));
        System.err.println(wordExist.exist(chars, "SEE"));
        System.err.println(wordExist.exist(chars, "ABCB"));
    }

    public boolean exist(char[][] board, String word) {
        boolean result;
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                if (aChar != word.charAt(0)) {
                    continue;
                }
                result = dsf(board, word, i, j, 0);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dsf(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        boolean result;
        board[i][j] <<= 2;
        result = dsf(board, word, i - 1, j, index + 1)
                || dsf(board, word, i + 1, j, index + 1)
                || dsf(board, word, i, j - 1, index + 1)
                || dsf(board, word, i, j + 1, index + 1);
        board[i][j] >>= 2;

        return result;
    }
}
