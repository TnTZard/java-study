package LeetCode1.困难;

/**
 * @Author: anzhi
 * @Date: 2021/3/9 13:55
 */
public class 给Nx3网格图涂色的方案数 {

    static final int MOD = 1000000007;

    public int numOfWays(int n) {
        long fi0 = 6, fi1 = 6;
        for (int i=2; i<=n; i++) {
            long newFi0 = (2*fi0 + 2*fi1) % MOD;
            long newFi1 = (2*fi0 + 3*fi1) % MOD;
            fi0 = newFi0;
            fi1 = newFi1;
        }
        return (int) ((fi0 + fi1) % MOD);
    }






}
