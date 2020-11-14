import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class LongestStringChain {
    EasyPrint ep = new EasyPrint();
    HashMap<String, Integer> map = new HashMap<>();
    String[] words;

    public int longestStrChain(String[] words) {
        this.words = words;
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        });

        int n = words.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            String wd = words[i];
            map.put(wd, i);
            if (wd.length() == 1) {
                dp[i] = 0;
            } else {
                checkPredecessor(i, dp);
            }
        }

        ep.printArray(dp);
        int ans = 0;
        for (int i = n - 1; i >= 0; --i) {
            ans = Math.max(ans, dp[i]);
        }
        return ans + 1;
    }

    private void checkPredecessor(int index, int[] dp) {
        String word = words[index];
        //System.out.print(word);
        int len = word.length();

        for (int i = 0; i < len; ++i) {
            String s = word.substring(0, i) + word.substring(i + 1);
            if (map.containsKey(s)) {
                dp[index] = Math.max(dp[index], dp[map.get(s)] + 1);
            }
        }
        //System.out.println(dp[index]);
    }

    public static void main(String[] args) {
        String[] words1 = {"ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh", "gr", "grukmj",
                "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru"};
        String[] words2 = {"a", "b", "ba", "bca", "bda", "bdca"};
        LongestStringChain p = new LongestStringChain();
        int res = p.longestStrChain(words2);
        System.out.println("result = " + res + " with expected answer " + 4);
    }
}
