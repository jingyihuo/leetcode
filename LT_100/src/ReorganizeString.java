import java.util.Arrays;

public class ReorganizeString {
    private EasyPrint ep = new EasyPrint();

    public String reorganizeString(String S) {
        int N = S.length();
        int[] counts = new int[26];
        for (char c : S.toCharArray()) counts[c - 'a'] += 100;
        ep.printArray(counts);
        for (int i = 0; i < 26; ++i) counts[i] += i;
        //Encoded counts[i] = 100*(actual count) + (i)
        ep.printArray(counts);
        Arrays.sort(counts);
        ep.printArray(counts);

        char[] ans = new char[N];
        int t = 1;
        for (int code : counts) {
            int ct = code / 100;
            char ch = (char) ('a' + (code % 100));
            if (ct > (N + 1) / 2) return "";
            for (int i = 0; i < ct; ++i) {
                if (t >= N) t = 0;
                ans[t] = ch;
                t += 2;
            }
        }
        System.out.println(ans);
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        ReorganizeString p = new ReorganizeString();
        p.reorganizeString("aab");
    }
}
