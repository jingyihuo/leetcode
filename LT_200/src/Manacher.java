public class Manacher {
    EasyPrint ep = new EasyPrint();

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

        int[] Z = new int[A.length];
        int center = 0, right = 0;
        ep.printArray(A);
        System.out.println("-----------");
        for (int i = 1; i < Z.length - 1; ++i) {
            if (i < right) {
                System.out.println("i = " + i + "; right = " + right);
                Z[i] = Math.min(right - i, Z[2 * center - i]);
            }
            while (A[i + Z[i] + 1] == A[i - Z[i] - 1])
                Z[i]++;
            if (i + Z[i] > right) {
                center = i;
                right = i + Z[i];
            }
            System.out.println("i = " + i + "; center = " + center + "; right = " + right);
            ep.printArray(Z);
        }
        int ans = 0;
        for (int v : Z) ans += (v + 1) / 2;
        return ans;
    }

    public static void main(String[] args) {
        String s = "ABAABA";
        Manacher p = new Manacher();
        p.countSubstrings(s);
    }
}
