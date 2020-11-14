public class MaxSquare {
    private EasyPrint ep = new EasyPrint();

    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] height = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];

        for (int i = 0; i < m; ++i) {

            // cal height
            for (int j = 0; j < n; ++j) {
                if (i == 0) {
                    height[i][j] = matrix[i][j] == '0' ? 0 : 1;
                } else {
                    height[i][j] = matrix[i][j] == '0' ? 0 : height[i - 1][j] + 1;
                }
            }

            int cur_left = 0;
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '0') {
                    left[i][j] = 0;
                    cur_left = j + 1;
                } else {
                    if (i == 0 || matrix[i - 1][j] == '0') {
                        left[i][j] = cur_left;
                    } else {
                        left[i][j] = Math.max(cur_left, left[i - 1][j]);
                    }
                }
            }

            int cur_right = n - 1;
            for (int j = n - 1; j >= 0; --j) {
                if (matrix[i][j] == '0') {
                    right[i][j] = n - 1;
                    cur_right = j - 1;
                } else {
                    if (i == 0 || matrix[i - 1][j] == '0') {
                        right[i][j] = cur_right;
                    } else {
                        right[i][j] = Math.min(cur_right, right[i - 1][j]);
                    }
                }
            }
        }
        ep.printArrays(height);
        ep.printArrays(left);
        ep.printArrays(right);
        int maxArea = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int side = Math.min(height[i][j], (right[i][j] - left[i][j] + 1));
                maxArea = Math.max(maxArea, side * side);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaxSquare p = new MaxSquare();
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0'
                , '0', '1', '0'}};
        p.maximalSquare(matrix);
    }
}
