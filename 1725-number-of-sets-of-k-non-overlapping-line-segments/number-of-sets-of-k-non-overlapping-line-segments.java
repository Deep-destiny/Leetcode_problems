
class Solution {
    int MOD = 1_000_000_007;
    int[][] dp = new int[1001][1001];

    public int numberOfSets(int n, int k) {

        for (int i = 0; i <= n; i++) {
            dp[0][i] = (i < n) ? 1 : 0;
        }

        for (int j = 1; j <= k; j++) {

            int[] prevRowSum = new int[n + 1];

            //prevRowSum[x] = dp[k-1][x] + dp[k-1][x+1] + ... + dp[k-1][n-1]
            for (int x = n - 1; x >= 0; x--) {
                prevRowSum[x] = (int) ((prevRowSum[x + 1] + dp[j - 1][x]) % MOD);
            }

            for (int i = n - 1; i >= 0; i--) {

                int skip = dp[j][i + 1];

                int take = prevRowSum[i + 1];
                //dp[k-1][i+1] + dp[k-1][i+2] ...... + dp[k-1][n-1]

                dp[j][i] = (take + skip) % MOD;
            }
        }

        return dp[k][0];
    }
}