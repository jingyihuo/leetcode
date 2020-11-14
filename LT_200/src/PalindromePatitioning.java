import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePatitioning {
    EasyPrint ep = new EasyPrint();
    List<List<String>> ans;
    Map<String, List<String>> map;

    public List<List<String>> partition(String s) {
        map = new HashMap<>();
        ans = new ArrayList<>();

        if (s.length() == 0) return ans;

        dfs(s, 1, new ArrayList<>());
        return ans;
    }

    private void dfs(String s, int start, List<String> curr) {
        if (s.length() == 0) {
            ep.printList(curr);
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (!isPalindrome(prefix)) {
                continue;
            }
            curr.add(prefix);
            dfs(s.substring(i), 1, curr);
            curr.remove(curr.size() - 1);
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePatitioning p = new PalindromePatitioning();
        p.partition("aab");
    }
}
