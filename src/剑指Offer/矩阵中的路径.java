package 剑指Offer;

/**
 * @Author: anzhi
 * @Date: 2021/1/27 18:19
 */
public class 矩阵中的路径 {

    /**
     *
     * [['a','b'],
     *  ['c','d']]
     *
     * [['A','B','C','E'],
     *  ['S','F','C','S'],
     *  ['A','D','E','E']]
     *
     * 深度优先搜索 + 剪枝
     *
     * 深度优先搜索：可以理解为暴力法遍历矩阵中所有字符串的可能性
     * DFS通过递归，先朝一个方向搜到底，再回溯至上个节点，沿另一个方向搜索，以此类推
     *
     *
     * 剪枝：在搜索中，遇到 这条路不可能和目标字符串匹配成功 的情况，则
     * 应立即返回，称之为“可行性剪枝”
     *
     *
     * DFS解析:
     * 递归参数: 当前元素在矩阵board中的行列索引i, j; 当前目标字符在word中的索引k
     * 终止条件: 1.行或列索引越界 2.当前矩阵元素与目标字符不同
     *
     *
     */

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

    }

    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        // borad.length -> 如例子：3
        for (int i=0; i<board.length; i++) {
            // board[0].length -> 一行数量：4
            for (int j=0; j<board[0].length; j++) {
                // 递归
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        // i>=board.length 越界; i<0
        if (i >= board.length || i < 0 ||
                //
                j >= board[0].length || j < 0 ||
                // 字符不匹配
                board[i][j] != word[k]) {
            return false;
        }
        // k与字符串长度相等  即字符串word已全部匹配
        if (k == word.length - 1) {
            return true;
        }
        // 朝四个方向搜索
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i-1, j, k+1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j-1, k + 1);
        board[i][j] = word[k];
        return res;
    }


    /**
     *
     * 回溯模板
     */

//    public static boolean exist1(char[][] board, String word) {
//        // 二维网格的长和宽
//        int height = board.length, width = board[0].length;
//        // 设置一个二维数组用于标记节点是否被访问过
//        boolean[][] visited = new boolean[height][width];
//        for (int i=0; i < height; i++) {
//            for (int j=0; j < width; j++) {
//                boolean flag = check(board, visited, i, j, word, 0);
//                if (flag) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    // 在二维网格中判断board[i][j]是否等于s[k]
//    public static boolean check(char[][] board, boolean[][] visited, int x, int y, String word, int index) {
//        if (board[x][y] != word.charAt(index)) {
//            return false;
//        } else if (index == word.length() - 1) {
//            return true;
//        }
//        visited[x][y] = true;
//        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//        boolean result = false;
//        for (int[] dir: directions) {
//
//        }
//    }



}
