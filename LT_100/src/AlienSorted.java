import java.util.HashMap;

public class AlienSorted {
    HashMap<Character, Integer> map = new HashMap<>();

    public boolean isAlienSorted(String[] words, String order) {

        for (int i = 0; i < order.length(); ++i) {
            map.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; ++i) {
            int cmp = compareTo(words[i], words[i + 1]);
            if (cmp > 0) {
                return false;
            }
        }
        return true;
    }

    private int compareTo(String s1, String s2) {
        int i = 0, j = 0;
        int order1 = 0, order2 = 0;
        while (i < s1.length() && j < s2.length()) {
            order1 = map.get(s1.charAt(i));
            order2 = map.get(s2.charAt(j));
            if (order1 > order2) {
                return 1;
            }
            if (order1 < order2) {
                return -1;
            }
            i++;
            j++;
        }
        if (i == s1.length() && j < s2.length()) {
            return -1;
        }
        if (i < s1.length() && j == s2.length()) {
            return 1;
        }
        return 0;
    }

    private void test1() {
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        boolean res = isAlienSorted(words, order);
        System.out.println("ans should be true. Our ans is " + res);
    }

    private void test2() {
        String[] words = {"word", "world", "row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        boolean res = isAlienSorted(words, order);
        System.out.println("ans should be false. Our ans is " + res);
    }

    public static void main(String[] args) {
        AlienSorted p = new AlienSorted();
        p.test2();
    }
}
