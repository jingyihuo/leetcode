import java.util.Arrays;

public class LongestIncreasing {
    private EasyPrint ep = new EasyPrint();

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            System.out.print("num: " + num + " i: " + i);
            if (i < 0) {
                i = -(i + 1);
            }
            System.out.println(" After: " + " i: " + i);
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        ep.printArray(dp);
        return len;
    }

    public static void main(String[] args) {
        LongestIncreasing p = new LongestIncreasing();
        int[] nums = {2, 2};
        p.lengthOfLIS(nums);
    }
}
