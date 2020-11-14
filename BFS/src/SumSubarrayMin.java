import java.util.Stack;

public class SumSubarrayMin {
    EasyPrint ep = new EasyPrint();

    public int sumSubarrayMins(int[] A) {
        int MOD = 1_000_000_007;
        int N = A.length;

        // prev has i* - 1 in increasing order of A[i* - 1]
        // where i* is the answer to query j
        Stack<Integer> stack = new Stack();
        int[] prev = new int[N];
        for (int i = 0; i < N; ++i) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()])
                stack.pop();
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        ep.printArray(prev);
        // next has k* + 1 in increasing order of A[k* + 1]
        // where k* is the answer to query j
        stack = new Stack();
        int[] next = new int[N];
        for (int k = N - 1; k >= 0; --k) {
            while (!stack.isEmpty() && A[k] < A[stack.peek()])
                stack.pop();
            next[k] = stack.isEmpty() ? N : stack.peek();
            stack.push(k);
        }
        ep.printArray(next);
        // Use prev/next array to count answer
        long ans = 0;
        for (int i = 0; i < N; ++i) {
            ans += (i - prev[i]) * (next[i] - i) % MOD * A[i] % MOD;
            ans %= MOD;
        }
        return (int) ans;

    }

    public static void main(String[] args) {
        SumSubarrayMin p = new SumSubarrayMin();
        int[] A = {10, 3, 4, 5, 3, 2, 3, 10};
        int[] a = {3, 1, 4, 2};
        int[] a2 = {10, 5, 3, 7, 0, 4, 5, 2, 1, 8};
        p.sumSubarrayMins(a2);
    }
}
