import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CriticalConnection {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; ++i) {
            nodes[i] = new Node(i);
        }

        for (List<Integer> list : connections) {
            Node n1 = nodes[list.get(0)];
            Node n2 = nodes[list.get(1)];
            n1.neighbors.add(n2);
            n2.neighbors.add(n1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Node node : nodes) {
            List<Integer> edge = new ArrayList<>();
            if (node.neighbors.size() == 1) {
                edge.add(node.label);
                edge.add(node.neighbors.get(0).label);
                Collections.sort(edge);
                if (!(map.containsKey(edge.get(0)) && map.get(edge.get(0)) == edge.get(1))) {
                    res.add(edge);
                    map.put(edge.get(0), edge.get(1));
                }

            }
        }
        return res;
    }

    class Node {
        public int label;
        public List<Node> neighbors;

        public Node(int v) {
            label = v;
            neighbors = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        CriticalConnection p = new CriticalConnection();
        List<List<Integer>> connections = new ArrayList<>();
        List<Integer> l1 = new ArrayList();
        l1.add(0);
        l1.add(1);


        p.criticalConnections(4, connections);
    }
}
