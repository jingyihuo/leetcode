public class InterleavingString {
    public boolean is_Interleave(String s1, int i, String s2, int j, String res, String s3) {
        System.out.println(res);
        if (res.equals(s3) && i == s1.length() && j == s2.length())
            return true;
        boolean ans = false;
        if (i < s1.length())
            ans |= is_Interleave(s1, i + 1, s2, j, res + s1.charAt(i), s3);
        if (j < s2.length())
            ans |= is_Interleave(s1, i, s2, j + 1, res + s2.charAt(j), s3);
        return ans;

    }

    public boolean isInterleave(String s1, String s2, String s3) {
        return is_Interleave(s1, 0, s2, 0, "", s3);
    }

    private void test1() {
        String s1 = "abc";
        String s2 = "bcd";
        String s3 = "abcbdc";
        isInterleave(s1, s2, s3);
    }

    public static void main(String[] args) {
        InterleavingString p = new InterleavingString();
        p.test1();
    }

}
