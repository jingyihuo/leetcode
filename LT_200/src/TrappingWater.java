import java.util.Stack;

public class TrappingWater {
    public int trap(int[] nums) {
        int ans = 0;

        Stack<Integer> stack = new Stack();
        int curr = 0;
        while (curr < nums.length) {
            while (!stack.isEmpty() && stack.peek() < nums[curr]) {
                int top = stack.peek();
            }

        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
