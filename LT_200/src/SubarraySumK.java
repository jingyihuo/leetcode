import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarraySumK {
    EasyPrint ep = new EasyPrint();

    public int subarraysDivByK(int[] A, int K) {

        int n = A.length;
        int[] presum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            presum[i] = (presum[i - 1] + A[i - 1]) % K;
        }
        ep.printArray(presum);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < presum.length; i++) {
            if (!map.containsKey(presum[i])) {
                map.put(presum[i], new ArrayList<>());
            }
            map.get(presum[i]).add(i - 1);
        }

        int ans = 0;
        for (int sum : map.keySet()) {
            List<Integer> indexes = map.get(sum);
            int num = indexes.size();
            if (sum == 0) {
                num--;
            }
            System.out.println(sum + " " + num);
            ans += num * (num - 1) / 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        SubarraySumK p = new SubarraySumK();
        int[] A = {4, 5, 0, -2, -3, 1};
        p.subarraysDivByK(A, 5);
    }
}
