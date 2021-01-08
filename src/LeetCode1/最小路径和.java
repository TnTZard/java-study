package LeetCode1;

/**
 * @Author: anzhi
 * @Date: 2020/11/14 15:32
 */
public class 最小路径和 {


    public static void main(String[] args) {

    }

    public static int minPathSum(int[][] grid) {
        if (grid.length <= 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        // 定义  dp[i][j] 到某个点的最小步数

        // 关系式 dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j];

        // 初始化
        dp[0][0] = grid[0][0];
        for (int i=1; i<m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i=1; i<n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
     *
     * 你可以对一个单词进行如下三种操作：
     *
     * 插入一个字符 删除一个字符 替换一个字符
     * 示例：
     * 输入: word1 = "horse", word2 = "ros"
     * 输出: 3
     * 解释:
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     */
    public static int minOperate(String s1, String s2) {

        // dp[i][j] 当s1长度为i s2长度为j 时 将s1转化成s2所使用的最少操作次数为dp[i][j]






        return 0;
    }







}
