public class Substring3Char {
    EasyPrint ep = new EasyPrint();

    public int numberOfSubstrings(String s) {
        int[] count = new int[3];

        int n = s.length();
        int i = 0, j = 0;
        count[s.charAt(j) - 'a']++;
        int ans = 0;
        while (j < n) {
            System.out.println("out i: " + i + " j: " + j);
            while (!formed(count)) {
                j++;
                System.out.println(j);
                count[s.charAt(j) - 'a']++;

                ep.printArray(count);
            }
            System.out.println("i: " + i + " j: " + j);
            while (formed(count) == true && i < j) {
                ans++;

                count[s.charAt(i) - 'a']--;
                i++;
                System.out.println("i: " + i + " ans: " + ans);
                ep.printArray(count);
            }
            System.out.println("ans: " + ans);
        }
        return ans;
    }

    private boolean formed(int[] count) {
        for (int i = 0; i < 3; i++) {
            if (count[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Substring3Char p = new Substring3Char();
        p.numberOfSubstrings("aaacba");
    }
}
