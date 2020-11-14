public class MinSwap {
    EasyPrint ep = new EasyPrint();

    public String minInteger(String num, int k) {
        char[] ca = num.toCharArray();
        helper(ca, 0, k);
        return new String(ca);
    }

    public void helper(char[] ca, int I, int k) {
        System.out.println("-------------");
        ep.printArray(ca);
        System.out.println("I: " + I + " k :" + k);
        if (k == 0 || I == ca.length) return;
        int min = ca[I], minIdx = I;
        System.out.println("Before : min: " + (char) min + " minIdx :" + minIdx);
        for (int i = I + 1; i < Math.min(I + k + 1, ca.length); i++)
            if (ca[i] < min) {
                min = ca[i];
                minIdx = i;
            }
        System.out.println("After : min: " + (char) min + " minIdx :" + minIdx);
        char temp = ca[minIdx];
        System.out.println("temp: " + temp);
        for (int i = minIdx; i > I; i--) ca[i] = ca[i - 1];
        ca[I] = temp;
        ep.printArray(ca);
        helper(ca, I + 1, k - (minIdx - I));
    }

    public static void main(String[] args) {
        MinSwap p = new MinSwap();
        String num = "4321";
        int k = 4;
        p.minInteger(num, k);
    }

}
