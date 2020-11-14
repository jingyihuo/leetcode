import java.util.Stack;

public class BasicCalculator_2 {
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
            if (ch == ' ') continue;
            // 考虑空格
            if ((!Character.isDigit(ch)) || i == s.length() - 1) {
                int pre;
                switch (sign) {
                    case '+':
                        stack.push(n);
                        break;
                    case '-':
                        stack.push(-n);
                        break;
                    case '*':
                        pre = stack.pop();
                        stack.push(pre * n);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre / n);
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
        BasicCalculator_2 p2 = new BasicCalculator_2();
        String s = " 3+ 5 / 2";
        int ans = p2.calculate(s);
        System.out.println(ans);
    }

}
