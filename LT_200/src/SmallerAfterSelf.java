import java.util.ArrayList;
import java.util.List;

public class SmallerAfterSelf {
    int[] index;
    int[] m;
    int[] tempIndex;
    List<Integer> ans = new ArrayList<>();
    EasyPrint ep = new EasyPrint();

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        this.m = new int[n];
        this.tempIndex = new int[n];
        this.index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        for (int i = 0; i < n; i++) {
            ans.add(0);
        }
        mergeSort(nums, 0, nums.length - 1);
        ep.printArray(nums);
        ep.printList(ans);
        return ans;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, right, mid);
    }

    private void merge(int[] nums, int start, int end, int mid) {
        int left = start, right = mid + 1;
        int p = start;

        while (left <= mid && right <= end) {
            // 左边指向数字小于等于右边指向数字，结果中加入左边指向的数字
            if (nums[left] <= nums[right]) {
                m[p] = nums[left];
                tempIndex[p] = index[left];
                // 更新右边已加入结果的数字们对刚加入的左边数字的贡献
                ans.set(index[left], ans.get(index[left]) + right - mid - 1);
                p++;
                left++;
            } else {
                // 右边指向数字比较小
                m[p] = nums[right];
                tempIndex[p] = index[right];
                p++;
                right++;
            }
        }

        // 结束时left没有走完
        while (left <= mid) {
            m[p] = nums[left];
            tempIndex[p] = index[left];
            // 更新右边已加入结果的数字们对刚加入的左边数字的贡献
            ans.set(index[left], ans.get(index[left]) + right - mid - 1);
            p++;
            left++;
        }

        // 结束时right没有走完
        while (right <= end) {
            m[p] = nums[right];
            tempIndex[p] = index[right];
            p++;
            right++;
        }

        // 更新数组和坐标
        for (int i = start; i <= end; i++) {
            index[i] = tempIndex[i];
            nums[i] = m[i];
        }
    }

    public static void main(String[] args) {
        SmallerAfterSelf p = new SmallerAfterSelf();
        int[] nums = {5, 2, 6, 1};
        p.countSmaller(nums);

    }
}
