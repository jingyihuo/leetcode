public class TreeAncestor {

    int[] parent;
    int[] height;
    EasyPrint ep = new EasyPrint();

    public TreeAncestor(int n, int[] parent) {
        this.parent = parent;
        this.height = new int[n];
        for (int i = 1; i < parent.length; ++i) {
            fillHeight(i);
        }
        ep.printArray(height);
    }

    public int getKthAncestor(int node, int k) {
        if (height[node] < k) return -1;
        int ans = node;
        while (k > 0) {
            ans = parent[ans];
            --k;
        }
        return ans;
    }

    private int fillHeight(int node) {
        if ((node == 0) || (height[node] != 0)) return height[node];
        height[node] = fillHeight(parent[node]) + 1;
        return height[node];
    }

    public static void main(String[] args) {
        int n = 7;
        int[] parent = {-1, 0, 0, 1, 1, 2, 2};
        TreeAncestor p = new TreeAncestor(n, parent);
        p.getKthAncestor(5, 3);
    }
}

