public class RegularExpression {
    EasyPrint ep = new EasyPrint();

    public boolean isMatch(String s, String p) {

        int s_len = s.length();
        int p_len = p.length();
        boolean[][] dp = new boolean[s_len + 1][p_len + 1];
        dp[s_len][p_len] = true;

        for (int i = s_len; i >= 0; i--) {
            for (int j = p_len - 1; j >= 0; j--) {
                boolean first_match = i < s_len && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');
                if (j + 1 < p_len && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (first_match && dp[i + 1][j]);
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }

        }
        ep.printArrays(dp);
        return dp[0][0];
    }

    public static void main(String[] args) {
        RegularExpression p = new RegularExpression();
        p.isMatch("aab", "c*a*b");
    }
}
