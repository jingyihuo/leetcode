import java.util.HashMap;
import java.util.Map;

public class ConfuseNumber {
    Map<Integer, Integer> map = new HashMap();
    private int ans;

    public int confusingNumberII(int N) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);

        dfs(0, 0, N);
        return N == 1000000000 ? ans + 1 : ans;
    }

    private void dfs(int curr, int k, int N) {

        if (k > 9 || curr > N) return; // 出口

        if (curr <= N && isConfuse(curr)) {
            //System.out.println(curr);
            ans++;
            //return; 这里千万不要返回，否则无法进行
        }

        for (int d : map.keySet()) {
            if (k == 0 && d == 0) continue; // 否则curr一直是0，进入死循环
            dfs(curr * 10 + d, k + 1, N);
        }
    }

    private boolean isConfuse(int num) {
        int k = num;
        long res = 0;
        while (k > 0) {
            // int d = k % 10;
            // int nd = map.get(d);
            // res = res * 10 + nd;
            res = res * 10 + map.get(k % 10);
            k = k / 10;
        }
        return res != num;
    }

    public static void main(String[] args) {
        ConfuseNumber p = new ConfuseNumber();
        int res = p.confusingNumberII(100);
        System.out.println("res: " + res);
    }
}
