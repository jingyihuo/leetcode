import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            if (ans.size() == 0) {
                ans.add(interval);
            } else {
                int[] last = ans.get(ans.size() - 1);
                if (interval[0] > last[1]) {
                    ans.add(interval);
                } else {
                    interval[1] = Math.max(interval[1], last[1]);
                }
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
