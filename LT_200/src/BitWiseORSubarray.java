import java.util.HashSet;
import java.util.Set;

public class BitWiseORSubarray {
    EasyPrint ep = new EasyPrint();

    public int subarrayBitwiseORs(int[] A) {
        int N = A.length;
        int[][] dp = new int[N][N];

        Set<Integer> ans = new HashSet<>();

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (i == j) {
                    dp[i][j] = A[i];
                } else {
                    if (i > 0 && j > 0 && dp[i - 1][j - 1] == dp[i][j - 1]) {
                        //System.out.println(i + " " + j + " " + dp[i - 1][j - 1] + " " + dp[i - 1][j]);
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 1] | A[j];
                    }
                }
                ans.add(dp[i][j]);
            }
        }
        ep.printArrays(dp);
        return ans.size();
    }

    public static void main(String[] args) {
        BitWiseORSubarray p = new BitWiseORSubarray();
        int[] A = {11, 2, 8, 3};
        p.subarrayBitwiseORs(A);
    }
}
