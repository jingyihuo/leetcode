import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestWPI {
    EasyPrint ep = new EasyPrint();

    public int longestWPI(int[] hours) {
        int[] pre_sum = new int[hours.length + 1];
        pre_sum[0] = 0;
        int res = 0;
        // 初始化前缀和数组 pre_sum[i]表示长度为i的数组的前缀和
        for (int i = 1; i <= hours.length; i++) {
            pre_sum[i] = pre_sum[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            /* 1.考虑[0:i-1]是最长序列  res是满足sum[0:i-1]>0的最长序列长度 */
            if (pre_sum[i] > 0) {
                res = i;
            }

        }
        System.out.println(Arrays.toString(pre_sum));

        HashMap<Integer, Integer> map = new HashMap<>();
        /* 记录第一次出现pre_sum[i]的索引i 即 使得前缀和是pre_sum[i]的最小索引 */
        for (int i = 0; i <= hours.length; i++) {
            if (pre_sum[i] < 0 && !map.containsKey(pre_sum[i])) {
                map.put(pre_sum[i], i);
                System.out.println("map: " + pre_sum[i] + " " + i);
            }
        }
        /*
        2.考虑[i:j]是最长序列 此时只需考虑pre_sum[j]<=0的情况
        在区间[0,j）中找一个i，使sum[i:j]>0且i尽可能小。
        推论1：pre_sum[i+1]<pre_sum[j+1]<=0。
        推论2：如果存在-(a+1),那么-a一定存在且-a一定会出现在-(a+1)之前
        根据推论，pre_sum[i+1]是小于pre_sum[j+1]的最大的负数，只能等于pre_sum[j+1]-1
        */
        for (int j = 0; j < hours.length; j++) {
            if (pre_sum[j] <= 0 && map.containsKey(pre_sum[j + 1] - 1)) {
                int i = map.get(pre_sum[j + 1] - 1);
                System.out.println("i:" + i + " j:" + j);
                if (i <= j) {
                    res = Math.max(j - i + 1, res);
                }
            }
        }
        return res;


    }

    public int longestWPI2(int[] hours) {
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            int temp = hours[i] > 8 ? 1 : -1;
            sum += temp;
            if (sum > 0)
                res = i + 1;
            else {
                if (!sumToIndex.containsKey(sum))
                    sumToIndex.put(sum, i);
                if (sumToIndex.containsKey(sum - 1))
                    res = Math.max(res, i - sumToIndex.get(sum - 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestWPI p = new LongestWPI();
        int[] hours = {9, 9, 6, 0, 6, 6, 9};
        p.longestWPI2(hours);
    }

}
