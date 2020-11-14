import java.util.Comparator;
import java.util.PriorityQueue;

public class PalindromicSubstring {
    private EasyPrint ep = new EasyPrint();

    public int countSubstrings(String S) {
        char[] A = new char[2 * S.length() + 3];
        A[0] = '@';
        A[1] = '#';
        A[A.length - 1] = '$';
        int t = 2;
        for (char c : S.toCharArray()) {
            A[t++] = c;
            A[t++] = '#';
        }
        ep.printArray(A);
        int[] Z = new int[A.length];
        int center = 0, right = 0;
        for (int i = 1; i < Z.length - 1; ++i) {
            if (i < right)
                Z[i] = Math.min(right - i, Z[2 * center - i]);
            while (A[i + Z[i] + 1] == A[i - Z[i] - 1])
                Z[i]++;
            if (i + Z[i] > right) {
                center = i;
                right = i + Z[i];
            }
        }
        ep.printArray(Z);
        int ans = 0;
        for (int v : Z) ans += (v + 1) / 2;
        System.out.println(ans);
        return ans;
    }


    public static void main(String[] args) {
        PalindromicSubstring p = new PalindromicSubstring();
        p.countSubstrings("ABAABA");
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

    }
}
