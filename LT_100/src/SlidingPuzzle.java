import java.util.*;

public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        int ans = 0;
        String target = "123450";

        String start = arrayToString(board);
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.offer(start);
        set.add(start);

        while (!q.isEmpty()) {
            int size = q.size();
            ans++;
            System.out.println(ans);
            for (int i = 0; i < size; ++i) {
                String current = q.poll();
                System.out.println("\t" + current);
                List<String> nextList = getNext(current);
                for (String next : nextList) {
                    if (next.equals(target)) {
                        System.out.println("\t the next is : " + next);
                        return ans;
                    }
                    if (!set.contains(next)) {
                        set.add(next);
                        q.offer(next);
                    }
                }
            }

        }

        return -1;  // ? make sure
    }

    private List<String> getNext(String str) {
        List<String> res = new ArrayList<>();
        int indexOfZero = str.indexOf("0");
        
        int[] direction = {-1, 1, -3, 3};
        for (int i = 0; i < 4; ++i) {
            StringBuilder sb = new StringBuilder(str);
            int nextIndex = indexOfZero + direction[i];
            if (nextIndex < 0 || nextIndex >= 6) {
                continue;
            }
            sb.setCharAt(nextIndex, '0');
            sb.setCharAt(indexOfZero, str.charAt(nextIndex));
            res.add(sb.toString());
        }
        return res;
    }

    private String arrayToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] board = {{3, 2, 4}, {1, 5, 0}};
        SlidingPuzzle p = new SlidingPuzzle();
        p.slidingPuzzle(board);
    }

}
