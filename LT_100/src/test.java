import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        consecutiveNumbersSum(15);
    }

    private static int consecutiveNumbersSum(int N) {
        int count = 0;
        // x > 0 --> N/k - (k + 1)/2 > 0
        int upper_limit = (int) (Math.sqrt(2 * N + 0.25) - 0.5);
        System.out.println(upper_limit);
        for (int k = 1; k <= upper_limit; ++k) {
            // x should be an integer
            if ((N - k * (k + 1) / 2) % k == 0)
                count++;
        }
        return count;
    }

    private void testAppend() {
        StringBuilder sb = new StringBuilder();

        int[][] board = {{1, 22, 3}, {4, 5, 0}};

        for (int[] row : board) {
            for (int i : row) {
                sb.append(i); // 直接用int就可以
            }
        }
        System.out.println(sb.toString());
    }

    private List<String> getNext(String str) {
        List<String> res = new ArrayList<>();
        int indexOfZero = str.indexOf("0");
        int[] direction = {-1, 1, -3, 3};
        for (int i = 0; i < 4; ++i) {
            StringBuilder sb = new StringBuilder(str);
            int nextIndex = indexOfZero + direction[i];
            if (nextIndex < 0 || nextIndex > 6) {
                continue;
            }
            sb.setCharAt(nextIndex, '0');
            sb.setCharAt(indexOfZero, str.charAt(nextIndex));
            res.add(sb.toString());
        }
        return res;
    }
}
