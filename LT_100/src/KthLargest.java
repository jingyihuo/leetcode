public class KthLargest {

    private EasyPrint ep = new EasyPrint();

    public int kthLargestElement(int k, int[] nums) {

        if (nums == null) {
            return -1;
        }

        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        ep.printArray(nums);
        System.out.println("start = " + start + " end = " + end);
        if (start == end) {
            return nums[start];
        }

        int i = start, j = end;
        int pivot = nums[i + (j - i) / 2];

        while (i <= j) {
            while (i <= j && nums[i] > pivot) {
                i++;
            }

            while (i <= j && nums[j] < pivot) {
                j--;
            }

            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        System.out.println("i = " + i + " j = " + j + " k = " + k);
        if (start + k - 1 <= j) {   // 要找的数在左边
            return quickSelect(nums, start, j, k);
        }

        if (start + k - 1 >= i) {   // 要找的数在i右边：左边有几个数：i-start
            return quickSelect(nums, i, end, k - (i - start));
        }
        // 在j和i之间的那个数
        return nums[j + 1];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 4, 6};
        KthLargest p = new KthLargest();
        int n = p.kthLargestElement(2, nums);
        System.out.println("result = " + n);
    }

}
