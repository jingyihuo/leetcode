import java.util.ArrayList;
import java.util.List;

public class LongestSubstring {
    private EasyPrint ep = new EasyPrint();
    private int ans = 0;

    public int longestSubstring(String s, int k) {
        int[] counts = new int[26];
        for (char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }

        //ep.printArray(counts);

        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (counts[ch - 'a'] > 0 && counts[ch - 'a'] < k) {
                indexes.add(i);
            }
        }

        return ans;
    }

    private void check(String s, int k, List<Integer> indexes) {
        if (indexes.size() == 0) {
            ans = s.length();
            return;
        }
        //ep.printList(indexes);

        int first = 0;
        ans = 0;
        for (int i : indexes) {
            String sub = s.substring(first, i);
            first = i;
        }
    }

    private boolean isValid(String s, int k) {
        if (s.length() < k) return false;
        int[] counts = new int[26];
        for (char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (counts[ch - 'a'] > 0 && counts[ch - 'a'] < k) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        LongestSubstring p = new LongestSubstring();
        String s = "bbaaacbd";
        int k = 3;
        int ans = p.longestSubstring(s, k);
        System.out.println(ans);
    }
}
