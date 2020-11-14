public class SplitSubArray {
    private EasyPrint ep = new EasyPrint();

    public int splitArray(int[] nums, int m) {
        int n = nums.length;

        int[][] dp = new int[n + 1][m + 1];
        int[] sub = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }

        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        ep.printArrays(dp);
        return dp[n][m];
    }

    public static void main(String[] args) {
        SplitSubArray p = new SplitSubArray();
        int[] nums = {7, 2, 5, 10, 8};
        int m = 2;
        p.splitArray(nums, m);
    }
}
