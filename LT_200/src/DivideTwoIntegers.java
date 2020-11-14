public class DivideTwoIntegers {
    public int divideTwoIntegers(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividend == 0) return 0;

        boolean isNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;

        int result = 0;
        while (a <= b) {
            System.out.println("a: " + a + " b:" + b);
            int shift = 0;
            while (a <= (b << shift) && (b << shift) < 0 && shift < 31) {
                shift++;
            }
            System.out.println("shift: " + shift);

            //停止时多了一次shift++
            a = a - (b << (shift - 1));
            result = result - (1 << (shift - 1));
            System.out.println("a: " + a + " result:" + result);
        }
        return isNegative ? result : -result;
    }

    public static void main(String[] args) {
        DivideTwoIntegers p = new DivideTwoIntegers();
        p.divideTwoIntegers(134, 3);
    }
}
