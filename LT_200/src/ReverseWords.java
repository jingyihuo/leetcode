public class ReverseWords {
    EasyPrint ep = new EasyPrint();

    public String reverseWords(String s) {
        String ans = "";
        String[] splits = s.split("\\s+");
        System.out.println(splits.length);
        for (int i = 0; i < splits.length; i++) {
            System.out.println(i + " " + splits[i] + " " + splits[i].length());
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "   hello, world!";
        String s2 = "a good    example";
        ReverseWords p = new ReverseWords();
        String target = p.reverseWords(s2);
        System.out.println(target);
    }
}
