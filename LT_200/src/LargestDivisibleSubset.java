import java.util.*;

public class LargestDivisibleSubset {
    EasyPrint ep = new EasyPrint();

    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Test case with empty set.
        int n = nums.length;
        if (n == 0) return new ArrayList();

        // Container to keep the largest divisible subset
        //   that ends with each of the nums.
        List<ArrayList> EDS = new ArrayList();
        for (int num : nums) EDS.add(new ArrayList());

        /* Sort the original list in ascending order. */
        Arrays.sort(nums);

        /* Calculate all the values of EDS(X_i) */
        for (int i = 0; i < n; ++i) {
            List<Integer> maxSubset = new ArrayList();

            // Find the largest divisible subset of previous elements.
            for (int k = 0; k < i; ++k)
                if (nums[i] % nums[k] == 0 && maxSubset.size() < EDS.get(k).size())
                    maxSubset = EDS.get(k);

            // Extend the found subset with the element itself.
            EDS.get(i).addAll(maxSubset);
            EDS.get(i).add(nums[i]);
        }
        /* Find the largest of EDS values  */
        List<Integer> ret = new ArrayList();
        for (int i = 0; i < n; ++i)
            if (ret.size() < EDS.get(i).size()) ret = EDS.get(i);
        return ret;
    }

    public List<Integer> largestDivisibleSubset2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums.length == 0) return ans;

        Arrays.sort(nums);

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, new ArrayList<>());
            map.get(num).add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = map.get(nums[i]);

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] % temp.get(temp.size() - 1) == 0) {
                    temp.add(nums[j]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            System.out.println("key: " + key);
            ep.printList(map.get(key));
            if (map.get(nums[i]).size() > max) {
                max = map.get(nums[i]).size();
                ans = map.get(nums[i]);
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        LargestDivisibleSubset p = new LargestDivisibleSubset();
        int[] nums = {5, 9, 18, 54, 108, 540, 90, 180, 360, 720};
        List<Integer> res = p.largestDivisibleSubset2(nums);
        p.ep.printList(res);
    }
}
