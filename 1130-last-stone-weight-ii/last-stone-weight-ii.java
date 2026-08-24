class Solution {
    public int lastStoneWeightII(int[] stones) {
       int n=stones.length;
         int sum = 0;
        for (int num : stones) {
            sum += num;
        }

        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Initialization
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                if (stones[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - stones[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        int ans = Integer.MAX_VALUE;

        // Check all possible subset sums
        for (int j = 0; j <= sum; j++) {
            if (dp[n][j]) {
                ans = Math.min(ans, Math.abs(sum - 2 * j));
            }
        }

        return ans;
    }
}
