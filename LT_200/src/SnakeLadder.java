public class SnakeLadder {
    private int[] getPosition(int id) {
        int N = 6;
        int x = N - 1 - (id - 1) / N;
        int y = (id - 1) % N;
        System.out.println(id + " " + x + " " + y);
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        SnakeLadder p = new SnakeLadder();
        for (int i = 1; i <= 36; i++) {
            p.getPosition(i);
        }
    }
}
