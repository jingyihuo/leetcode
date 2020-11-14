public class LongestAbsolutePath {

    public int lengthLongestPath(String input) {
        // Write your code here
        if (input.length() == 0) {
            return 0;
        }
        int ans = 0;
        int[] sum = new int[input.length() + 1];

        for (String line : input.split("\n")) {
            int indexOft = line.lastIndexOf('\t');
            int level = indexOft + 2;
            System.out.println("line: " + line + " index of t: " + indexOft + " level : " + level);

            int len = line.length() - (level - 1);
            System.out.println("len : " + len);
            if (line.contains(".")) {
                ans = Math.max(ans, sum[level - 1] + len);
                System.out.println("ans: " + ans + "\n");
            } else {
                sum[level] = sum[level - 1] + len + 1;
                System.out.println("sum[" + level + "]: " + sum[level]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        LongestAbsolutePath p = new LongestAbsolutePath();
        String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        p.lengthLongestPath(s);

    }
}
