public class MinSwap2 {
    EasyPrint ep = new EasyPrint();
    String ans = "";

    public String minInteger(String num, int k) {
        if (num.length() == 1) return num;
        StringBuilder sb = new StringBuilder(num);
        //System.out.println(sb.toString());
        dfs(sb, 0, k);
        System.out.println("main hashcode: " + sb.hashCode());
        return sb.toString();
    }

    private void dfs(StringBuilder sb, int index, int k) {
        System.out.println("-------------");
        System.out.println("sb: " + sb.toString() + " I: " + index + " k :" + k);

        if (k <= 0 || index >= sb.length()) {
            System.out.println("dfs hashcode: " + sb.hashCode() + " " + sb.toString());
            return;
        }

        int min = 9;
        int posOfMin = index;
        System.out.println("Before : min: " + min + " posOfMin :" + posOfMin);
        for (int i = index; i < sb.length(); i++) {
            if (sb.charAt(i) - '0' < min && i - index <= k) {
                min = sb.charAt(i) - '0';
                posOfMin = i;
            }
        }
        System.out.println("After : min: " + min + " posOfMin :" + posOfMin);

        if (posOfMin == index) dfs(sb, index + 1, k);
        else {
            char ch = sb.charAt(posOfMin);
            sb.deleteCharAt(posOfMin);
            StringBuilder pre = new StringBuilder(sb.substring(0, index));
            StringBuilder post = new StringBuilder(sb.substring(index));
            sb = new StringBuilder(pre);
            sb.append(ch);
            sb.append(post);
            System.out.println("going to next: " + sb.toString());
            dfs(sb, index + 1, k - (posOfMin - index));
        }
    }

    public static void main(String[] args) {
        MinSwap2 p = new MinSwap2();
        String num = "4321";
        int k = 4;
        String s = p.minInteger(num, k);
        System.out.println("ans: " + s);
    }
}
