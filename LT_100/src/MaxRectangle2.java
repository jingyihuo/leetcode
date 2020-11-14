public class MaxRectangle2 {
    private EasyPrint ep = new EasyPrint();

    public int maximalRectangle(char[][] A) {
        // A is boolean
        // when calculating left and right, check A[i-1][j] is true
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int m = A.length;
        int n = A[0].length;
        int[][] up = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        int[][] res = new int[m][n];
        int i, j, k, l, r = 0;

        for (i = 0; i < m; ++i) {
            // calc up
            for (j = 0; j < n; ++j) {
                if (A[i][j] != '1') {
                    up[i][j] = 0;
                } else {
                    up[i][j] = 1;
                    if (i > 0) {
                        up[i][j] += up[i - 1][j];
                    }
                }
            }

            // calc left
            l = 0;
            for (j = 0; j < n; ++j) {
                if (A[i][j] != '1') {
                    l = left[i][j] = 0;
                } else {
                    ++l;
                    left[i][j] = l;
                    if (i > 0 && A[i - 1][j] == '1' && left[i - 1][j] < left[i][j]) {
                        left[i][j] = left[i - 1][j];
                    }
                }
            }

            // calc right
            r = 0;
            for (j = n - 1; j >= 0; --j) {
                if (A[i][j] != '1') {
                    r = right[i][j] = 0;
                } else {
                    ++r;
                    right[i][j] = r;
                    if (i > 0 && A[i - 1][j] == '1' && right[i - 1][j] < right[i][j]) {
                        right[i][j] = right[i - 1][j];
                    }
                }
            }
        }

        System.out.println("height: ");
        ep.printArrays(up);

        System.out.println("left: ");
        ep.printArrays(left);

        System.out.println("right: ");
        ep.printArrays(right);
        int max = 0;
        for (i = 0; i < m; ++i) {
            for (j = 0; j < n; ++j) {
                res[i][j] = up[i][j] * (left[i][j] + right[i][j] - 1);
                max = Math.max(max, res[i][j]);
            }
        }
        System.out.println("res: ");
        ep.printArrays(res);
        return max;
    }

    public static void main(String[] args) {
        MaxRectangle2 p = new MaxRectangle2();
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1',
                '1', '1'}, {'1', '0', '0', '1', '0'}};
        p.maximalRectangle(matrix);
    }
}
