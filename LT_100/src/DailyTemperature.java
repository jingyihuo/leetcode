import java.util.Arrays;

public class DailyTemperature {
    EasyPrint ep = new EasyPrint();

    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = T.length - 1; i >= 0; --i) {
            System.out.println("current Temperature: " + T[i]);
            int warmer_index = Integer.MAX_VALUE;

            for (int t = T[i] + 1; t <= 100; ++t) {
                if (next[t] < warmer_index)
                    warmer_index = next[t];
            }
            System.out.println("warmer_index : " + warmer_index);
            if (warmer_index < Integer.MAX_VALUE) {
                // update ans
                ans[i] = warmer_index - i;
            }
            System.out.println("ans[" + i + "] : " + ans[i]);
            // update int[] next
            next[T[i]] = i;
            System.out.println("next[" + T[i] + "] : " + i);
        }
        ep.printArray(ans);
        return ans;
    }

    public static void main(String[] args) {
        DailyTemperature p = new DailyTemperature();
        int[] temperature = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = p.dailyTemperatures(temperature);

    }
}
