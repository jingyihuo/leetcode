import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, String[] wordDict) {
        return dfs(s, new HashSet(Arrays.asList(wordDict)), 0, new Boolean[s.length()]);
    }

    private boolean dfs(String s, Set<String> dict, int start, Boolean[] memo) {
        System.out.println("start: " + start);

        if (start == s.length()) return true;
        System.out.println("memo: " + memo[start]);

        if (memo[start] != null) return memo[start];

        for (int end = start + 1; end <= s.length(); end++) {
            String sub = s.substring(start, end);
            System.out.println(sub);
            if (dict.contains(sub) && dfs(s, dict, end, memo)) {
                System.out.println("record memo[" + start + "] = " + true);
                return memo[start] = true;
            }
        }
        System.out.println("record memo[" + start + "] = " + false);
        return memo[start] = false;
    }

    public static void main(String[] args) {
        WordBreak p = new WordBreak();
        //p.test1();
        p.test2();
    }

    private void test1() {
        String s = "catsandog";
        String[] wordDict = {"cat", "cats", "sand", "and", "dog"};
        boolean ans = wordBreak(s, wordDict);
        System.out.println(ans);
    }

    private void test2() {
        String s =
                "aaaab";

        String[] wordDict = {"aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
                "aaaaaaaaaa"};
        boolean ans = wordBreak(s, wordDict);
        System.out.println(ans);
    }
}
