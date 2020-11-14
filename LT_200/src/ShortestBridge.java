import java.util.*;

public class ShortestBridge {
    EasyPrint ep = new EasyPrint();

    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    int R, C;
    int ans = 0;

    public int shortestBridge(int[][] A) {
        int[][] islands = Arrays.copyOf(A, A.length);
        R = A.length;
        C = A[0].length;

        MarkIsland:
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (islands[i][j] == 1) {
                    //System.out.println(i + " " + j);
                    dfs(i, j, islands);
                    break MarkIsland;
                }
            }
        }

        ep.printArrays(islands);
        bfs(islands);
        ep.printArrays(islands);
        return ans;
    }

    private void dfs(int x, int y, int[][] islands) {

        islands[x][y] = 2;
        for (int[] next : getNextPosition(x, y)) {
            if (islands[next[0]][next[1]] == 1) {
                dfs(next[0], next[1], islands);
            }
        }
    }

    private void bfs(int[][] islands) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> target = new HashSet<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (islands[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                } else if (islands[i][j] == 2) {
                    target.add(i * R + j);
                }
            }
        }

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            System.out.println("level:" + " " + level);
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];
                System.out.println("\t curr: " + x + " " + y);
                for (int[] next : getNextPosition(x, y)) {
                    int nx = next[0], ny = next[1];
                    System.out.println("\t next: " + nx + " " + ny);

                    if (islands[nx][ny] == 2) {
                        ans = level - 1;
                        return;
                    } else if (islands[nx][ny] == 1) {
                        continue;
                    } else if (islands[nx][ny] == 0) {
                        islands[nx][ny] = 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    private List<int[]> getNextPosition(int x, int y) {
        List<int[]> nextList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                nextList.add(new int[]{nx, ny});
            }
        }
        return nextList;
    }

    public static void main(String[] args) {
        ShortestBridge p = new ShortestBridge();
        //int[][] A = {{0, 1}, {1, 0}};
        int[][] A = {{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
        int ans = p.shortestBridge(A);
        System.out.println(ans);
    }
}
