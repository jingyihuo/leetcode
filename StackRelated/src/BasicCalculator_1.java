import java.util.Stack;

public class BasicCalculator_1 {
    public int calculate(String s) {
        int res = 0;

        Stack<Integer> stack = new Stack<>();
        int n = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                n = n * 10 + (ch - '0');
            }

            if (!Character.isDigit(ch) || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(n);
                        break;
                    case '-':
                        stack.push(-n);
                        break;
                }

                sign = ch;
                n = 0;
            }
        }
        //System.out.println(stack.size());
        while (!stack.isEmpty()) {
            //ystem.out.println(stack.pop());
            res += stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        BasicCalculator_1 p1 = new BasicCalculator_1();
        String s = "72-8+9-10";
        int ans = p1.calculate(s);
        System.out.println(ans);
    }
}
