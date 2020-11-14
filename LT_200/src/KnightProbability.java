public class KnightProbability {
    EasyPrint ep = new EasyPrint();

    public double knightProbability(int N, int K, int sr, int sc) {
        int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dc = {1, -1, -2, 2, -2, 2, -1, 1};

        double[][] dp_prev = new double[N][N];
        dp_prev[sr][sc] = 1;

        for (int t = K; t > 0; t--) {
            double[][] dp_curr = new double[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (dp_prev[r][c] > 0) {
                        for (int d = 0; d < 8; d++) {
                            int cr = r + dr[d];
                            int cc = c + dc[d];

                            if (cr >= 0 && cr < N && cc >= 0 && cc < N) {
                                //System.out.println("r : " + r + " c: " + c + " cr: " + cr + " cc : " + cc);
                                //System.out.println("dp_prev[r][c] : " + dp_prev[r][c]);
                                //System.out.println("dp_curr[r][c] : " + dp_curr[cr][cc]);
                                dp_curr[cr][cc] += dp_prev[r][c] / 8.0;
                                //System.out.println("dp_curr[r][c] : " + dp_curr[cr][cc]);
                            }
                        }
                    }
                }
            }
            ep.printArrays(dp_curr);
            dp_prev = dp_curr;
        }

        double ans = 0.0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans += dp_prev[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        KnightProbability p = new KnightProbability();
        double ans = p.knightProbability(3, 2, 0, 0);
        System.out.println(ans);
    }
}
