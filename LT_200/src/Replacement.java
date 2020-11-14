public class Replacement {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int mostFreqLetter = 0;
        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {
            //System.out.println(right + " " + s.charAt(right));
            freq[s.charAt(right) - 'A']++;
            //System.out.println(s.charAt(right) - 'A' + " " + freq[s.charAt(right) - 'A']);
            mostFreqLetter = Math.max(mostFreqLetter, freq[s.charAt(right) - 'A']);
            System.out.println(mostFreqLetter);
            int lettersToChange = (right - left + 1) - mostFreqLetter;

            if (lettersToChange > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            } // 只要要删除的字母个数大于k，就持续删除前面的字母，更改频率

            max = Math.max(max, right - left + 1);
            System.out.println("---------------");
        }

        return max;
    }

    public static void main(String[] args) {
        Replacement p = new Replacement();
        String s = "AABABBAAAA";
        int k = 2;
        int res = p.characterReplacement(s, k);
        System.out.println(res);
    }
}
