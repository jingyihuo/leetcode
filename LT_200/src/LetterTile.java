import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterTile {
    EasyPrint ep = new EasyPrint();
    int ans = 0;
    int[] factorail = new int[8];

    public int numTilePossibilities(String tiles) {
        setFactorail();
        ep.printArray(factorail);
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        dfs(chars, new ArrayList<Character>(), 0);

        //System.out.println(res.size());

        return ans;
    }

    private void dfs(char[] chars, List<Character> curr, int start) {
        ep.printList(curr);
        int currAns = calculate(curr);
        System.out.print("currAns: " + currAns);
        ans += currAns;
        System.out.println(" ans: " + ans);

        for (int i = start; i < chars.length; i++) {
            if (i != 0 && chars[i] == chars[i - 1] && i > start) {
                continue;
            }
            curr.add(chars[i]);
            dfs(chars, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }

    private int calculate(List<Character> curr) {
        int n = curr.size();
        int[] chars = new int[26];
        for (char ch : curr) {
            chars[ch - 'A']++;
        }
        //System.out.print("n: " + n);
        int currAns = factorail[n];
        //System.out.print("currAns: " + currAns);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 0) {
                //System.out.print("i : "+ i + " chars[i]: " + chars[i]);
                currAns = currAns / factorail[chars[i]];
            }
        }
        return currAns;
    }

    private void setFactorail() {
        factorail[0] = 0;
        factorail[1] = 1;
        for (int i = 2; i < 8; i++) {
            factorail[i] = factorail[i - 1] * i;
        }
    }

    public static void main(String[] args) {
        LetterTile p = new LetterTile();
        int res = p.numTilePossibilities("AAABBC");
        System.out.println(res);
    }
}
