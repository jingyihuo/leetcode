public class AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder big;
        String small;
        if (num1.length() >= num2.length()) {
            big = new StringBuilder(num1);
            small = num2;
        } else {
            big = new StringBuilder(num2);
            small = num1;
        }

        int carry = 0, sum = 0;
        int j = small.length() - 1;
        for (int i = big.length() - 1; i >= 0; --i) {
            //System.out.println(i);
            if (j >= 0) {
                sum = (big.charAt(i) - '0') + (small.charAt(j) - '0') + carry;
                j--;
            } else {
                sum = (big.charAt(i) - '0') + carry;
            }
            carry = sum / 10;
            sum = sum % 10;
            
            big.setCharAt(i, (char) (sum + 48));
        }

        return (carry == 0) ? big.toString() : "1" + big.toString();
    }

    public static void main(String[] args) {
        AddStrings p = new AddStrings();
        String res = p.addStrings("999", "9");
        System.out.println(res);
    }
}
