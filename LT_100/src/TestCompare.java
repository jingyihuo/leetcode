public class TestCompare {
    private EasyPrint ep = new EasyPrint();

    public static void main(String[] args) {
        TestCompare p = new TestCompare();

        String s = "a****bc**c";
        String[] ss = s.split("\\*+");
        p.ep.printArray(ss);
        String sn = String.join("*", ss);
        System.out.println(sn);
        /*
        //String s1 = "abc";
        //String s2 = "xyz";
        String[] strs = {"abc", "xyz", "kfjm", "sjt"};
        List<String> res = Arrays.asList(strs);
        Collections.sort(res, (s1, s2) -> s1.compareTo(s2));
        p.ep.printList(res);
        int x = (int) Math.pow(4, 2.0);
        System.out.println(x);

        //int x = s2.compareTo(s1);
        //System.out.println(x);

         */
    }
}
