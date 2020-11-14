import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    private EasyPrint ep = new EasyPrint();

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }

        dfs(n, "", res, 0, 0);
        ep.printList(res);
        return res;
    }

    private void dfs(int n, String now, List<String> res, int open, int close) {
        if (now.length() == 2 * n) {
            res.add(now);
            return;
        }

        if (open > close) {
            dfs(n, now + ")", res, open, close + 1);
        }
        if (open < n) {
            dfs(n, now + "(", res, open + 1, close);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis p = new GenerateParenthesis();
        List<String> res = p.generateParenthesis(3);

    }
}
