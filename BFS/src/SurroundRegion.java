import java.util.*;

public class SurroundRegion {
    EasyPrint ep = new EasyPrint();
    int[][] find;
    char[][] board;

    public void solve(char[][] input) {
        this.board = input;
        int m = board.length;
        int n = board[0].length;
        find = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(find[i], 0);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    bfs(i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (find[i][j] == 1) {
                    input[i][j] = 'X';
                } else {
                    input[i][j] = 'O';
                }

            }
        }
        ep.printArrays(find);
        ep.printArrays(input);
    }

    private void bfs(int i, int j) {
        //System.out.println(i + " " + j);
        Queue<Coordinate> q = new LinkedList<>();
        q.offer(new Coordinate(i, j));
        find[i][j] = 1;

        while (!q.isEmpty()) {
            Coordinate p = q.poll();
            for (Coordinate next : getNext(p)) {
                if (find[next.x][next.y] != 1 && board[i][j] == 'O') {
                    q.offer(next);
                    find[next.x][next.y] = 1;
                }
            }
        }
    }

    private List<Coordinate> getNext(Coordinate curr) {
        List<Coordinate> ans = new ArrayList<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + curr.x;
            int ny = dy[i] + curr.y;
            if (nx >= 0 && nx < find.length && ny >= 0 && ny < find[0].length && board[nx][ny] == 'O') {
                ans.add(new Coordinate(nx, ny));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SurroundRegion p = new SurroundRegion();
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        p.solve(board);
    }
}

class Coordinate {
    public int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
