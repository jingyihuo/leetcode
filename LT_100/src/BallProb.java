import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BallProb {
    private EasyPrint ep = new EasyPrint();
    int count = 0;
    int colors = 0;
    int total = 0;

    public double getProbability(int[] balls) {
        double res = 0.0;
        colors = balls.length;
        List<Integer> singleBalls = new ArrayList<>();
        for (int i = 0; i < balls.length; i++) {
            for (int j = 0; j < balls[i]; ++j) {
                singleBalls.add(i + 1);
            }
        }
        //ep.printList(singleBalls);
        dfs(singleBalls, new ArrayList<Integer>(), new boolean[singleBalls.size()]);
        System.out.println(count + " " + total);
        res = count * 1.0 / total;
        return res;
    }

    private void dfs(List<Integer> balls, List<Integer> current, boolean[] visited) {
        if (current.size() == balls.size()) {
            //System.out.println("yes");
            total++;
            if (checkColor(current)) {
                count++;
            }
            return;
        }

        for (int i = 0; i < balls.size(); ++i) {

            if (visited[i]) {
                continue;
            }
            if (i > 0 && balls.get(i) == balls.get(i - 1) && !visited[i - 1]) {
                continue;
            }
            //System.out.println(i + " " + balls.get(i));
            visited[i] = true;
            current.add(balls.get(i));
            dfs(balls, current, visited);
            visited[i] = false;
            current.remove(current.size() - 1);
        }

    }

    private boolean checkColor(List<Integer> curr) {
        //ep.printList(curr);
        HashSet<Integer> set1 = new HashSet<>();
        for (int i = 0; i < curr.size() / 2; ++i) {
            if (!set1.contains(curr.get(i))) {
                set1.add(curr.get(i));
            }
        }
        int n1 = set1.size();

        HashSet<Integer> set2 = new HashSet<>();
        for (int i = curr.size() / 2; i < curr.size(); ++i) {
            if (!set2.contains(curr.get(i))) {
                set2.add(curr.get(i));
            }
        }
        int n2 = set2.size();

        //System.out.println(n1 + " " + n2);
        if (n1 == n2) {
            //ep.printList(curr);
            //System.out.println(n1 + " " + n2);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BallProb p = new BallProb();
        int[] b = {6, 6, 6, 6, 6, 6};
        double res = p.getProbability(b);
        System.out.println(res);

    }
}
