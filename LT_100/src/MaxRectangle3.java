import java.util.Arrays;

public class MaxRectangle3 {
    private EasyPrint ep = new EasyPrint();

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] left = new int[m][n]; // initialize left as the leftmost boundary possible
        int[][] right = new int[m][n];
        int[][] height = new int[m][n];
        for (int[] row : right) {
            Arrays.fill(row, n); // initialize right as the rightmost boundary possible
        }
        int maxarea = 0;
        for (int i = 0; i < m; i++) {
            //System.out.println("--------- i = " + i + " ---------");
            int cur_left = 0, cur_right = n;
            // update height
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[i][j] = 1;
                    if (i > 0) {
                        height[i][j] = height[i - 1][j] + 1;
                    }

                } else {
                    height[i][j] = 0;
                }
            }

            // update left
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = cur_left;
                    if (i > 0 && matrix[i - 1][j] == '1') {
                        left[i][j] = Math.max(left[i - 1][j], cur_left);
                    }
                } else {
                    left[i][j] = 0;
                    cur_left = j + 1;
                }
            }

            // update right
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[i][j] = cur_right;
                    if (i > 0 && matrix[i - 1][j] == '1') {
                        right[i][j] = Math.min(right[i - 1][j], cur_right);
                    }
                } else {
                    right[i][j] = n;
                    cur_right = j;
                }
            }

            // update area

        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = (right[i][j] - left[i][j]) * height[i][j];
                maxarea = Math.max(res[i][j], maxarea);
            }
        }

        System.out.println("area = " + maxarea);

        System.out.println("height: ");
        ep.printArrays(height);

        System.out.println("left: ");
        ep.printArrays(left);

        System.out.println("right: ");
        ep.printArrays(right);

        ep.printArrays(res);
        return maxarea;
    }

    public static void main(String[] args) {
        MaxRectangle3 p = new MaxRectangle3();
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1',
                '1', '1'}, {'1', '0', '0', '1', '0'}};
        p.maximalRectangle(matrix);
    }
}
