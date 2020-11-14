import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnections {
    private EasyPrint ep = new EasyPrint();
    private List<Integer>[] edges;
    private int[] DFN;
    private int[] LOW;
    private boolean[] visited;
    private List<List<Integer>> ans;
    private int t;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        this.edges = new ArrayList[n];
        this.DFN = new int[n];
        this.LOW = new int[n];
        this.visited = new boolean[n];
        this.ans = new ArrayList<>();
        this.t = 0;
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (List<Integer> conn : connections) {
            int n1 = conn.get(0), n2 = conn.get(1);
            edges[n1].add(n2);
            edges[n2].add(n1);
        }
        tarjan(0, -1);
        //ep.printArray(DFN);

        //ep.printArray(LOW);
        return ans;
    }

    public void tarjan(int cur, int pre) {
        t++;
        DFN[cur] = t;
        LOW[cur] = t;
        visited[cur] = true;
        for (int node : edges[cur]) {
            if (node == pre) continue;
            if (!visited[node]) {
                tarjan(node, cur);
                LOW[cur] = Math.min(LOW[cur], LOW[node]);
                if (LOW[node] > DFN[cur]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(node);
                    ans.add(list);
                }
            } else {
                LOW[cur] = Math.min(LOW[cur], DFN[node]);
            }
        }

    }

    public static void main(String[] args) {
        CriticalConnections p = new CriticalConnections();
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(0, 2));
        connections.add(Arrays.asList(0, 3));
        connections.add(Arrays.asList(1, 3));
        connections.add(Arrays.asList(2, 3));
        connections.add(Arrays.asList(2, 4));
        connections.add(Arrays.asList(4, 5));
        connections.add(Arrays.asList(3, 5));
        List<List<Integer>> ans = p.criticalConnections(6, connections);

        p.ep.printDoubleList(ans);
    }
}
