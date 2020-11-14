import java.util.*;

public class SteppingNumber {
    EasyPrint ep = new EasyPrint();
    Set<Integer> set;
    int low, high;

    public List<Integer> countSteppingNumbers(int low, int high) {
        set = new HashSet<>();
        this.low = low;
        this.high = high;

        for (int i = 0; i <= 9; i++) {
            dfs(i, 0);
        }
        List<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        ep.printList(ans);
        return ans;
    }

    private void dfs(int curr, int k) {
        System.out.println(curr + " ");
        if (curr > high) return;
        if (curr >= low && curr <= high) {
            System.out.println("yes");
            set.add(curr);
        }
        int lastD = curr % 10;
        int inc = curr * 10 + (curr % 10) + 1;
        int dec = curr * 10 + (curr % 10) - 1;

        if (lastD == 0) {
            dfs(inc, k + 1);
        } else if (lastD == 9) {
            dfs(dec, k + 1);
        } else {
            dfs(inc, k + 1);
            dfs(dec, k + 1);
        }
    }

    public static void main(String[] args) {

        SteppingNumber p = new SteppingNumber();
        p.countSteppingNumbers(0, 21);

    }
}
