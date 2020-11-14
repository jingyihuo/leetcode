public class MathTest {

    public static int gcd(int m, int n) {
        System.out.println("m : " + m + " n: " + n);
        if (m < n) {
            int t = m;
            m = n;
            n = t;
        }
        if (m % n == 0) return n;
        return gcd(n, m % n);
    }

    public static int lcm(int m, int n) {
        return m * n / gcd(m, n);
    }

    public static void main(String[] args) {
        int m = 4, n = 6;
        int ans = lcm(m, n);
        System.out.println(ans);
    }
}
