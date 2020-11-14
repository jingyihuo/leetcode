import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PancakeSort {
    EasyPrint ep = new EasyPrint();

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList();
        int N = A.length;

        ep.printArray(A);

        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i)
            B[i] = i + 1;

        ep.printArray(B);
        
        Arrays.sort(B, (i, j) -> A[j - 1] - A[i - 1]);

        ep.printArray(B);

        for (int i : B) {
            for (int f : ans)
                if (i <= f)
                    i = f + 1 - i;
            ans.add(i);
            ans.add(N--);
        }

        return ans;
    }

    public static void main(String[] args) {
        PancakeSort p = new PancakeSort();
        int[] A = {3, 2, 4, 1};
        p.pancakeSort(A);
    }
}
