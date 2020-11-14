public class SpiralMatrix2 {
    int N;
    EasyPrint ep = new EasyPrint();

    public int[][] generateMatrix(int n) {
        this.N = n;
        int[][] ans = new int[n][n];

        int d = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int r = 0, c = 0, nr = 0, nc = 0;
        int val = 1;

        while (val < n * n + 1) {
            ans[r][c] = val;
            val++;
            nr = r + dirs[d][0];
            nc = c + dirs[d][1];
            if (outBound(nr, nc) || ans[nr][nc] != 0) {
                d = (d + 1) % 4;
                nr = r + dirs[d][0];
                nc = c + dirs[d][1];
            }
            r = nr;
            c = nc;
        }
        ep.printArrays(ans);
        return ans;
    }

    private boolean outBound(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        SpiralMatrix2 p = new SpiralMatrix2();
        p.generateMatrix(5);

    }
}
