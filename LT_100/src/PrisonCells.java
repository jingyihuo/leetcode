import java.util.HashMap;
import java.util.Map;

public class PrisonCells {
    private EasyPrint ep = new EasyPrint();

    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<Integer, Integer> seen = new HashMap<>();
        Map<Integer, Integer> dayToCell = new HashMap<>();
        int state = 0;
        for (int i = 0; i < 8; ++i) {
            if (cells[i] == 1) {
                state = state ^ (1 << (7 - i));
            }
        }
        //System.out.println(Integer.toBinaryString(state));

        int t = 0;
        while (N > 0) {
            System.out.printf("%5d", state);
            System.out.println(" " + Integer.toBinaryString(state));
            if (seen.containsKey(state)) {
                int cycleStart = seen.get(state);
                int period = t - cycleStart;
                System.out.println("t: " + t);
                System.out.println("cycleStart " + cycleStart + " ");
                System.out.println("the period of cycle : " + (period) + " ");
                //System.out.println("the period of cycle : " + (seen.get(state) - N) + " ");
                N = N - cycleStart + 1;
                N %= period;
                System.out.println("days remained: " + N);
                state = dayToCell.get(N);
                break;
            }
            seen.put(state, t);
            dayToCell.put(t, state);
            t++;
            // if before the cycle formed
            if (N >= 1) {
                N--;
                state = getNextDay(state);
            }
        }
        //System.out.println(Integer.toBinaryString(state));
        int[] ans = new int[8];
        for (int i = 0; i < 8; ++i) {
            if (((state >> i) & 1) > 0) {
                ans[7 - i] = 1;
            }
        }
        return ans;
    }

    private int getNextDay(int state) {

        // (state)2 = (1011001)
        int nextState = 0;
        for (int i = 1; i <= 6; ++i) {
            if (((state >> (i - 1)) & 1) == ((state >> (i + 1)) & 1)) {
                nextState = nextState ^ (1 << i);
            }
        }

        return nextState;
    }

    private void test1() {
        int[] cells = {1, 0, 0, 1, 0, 0, 1, 0};
        int N = 100;
        int[] r = prisonAfterNDays(cells, N);
        ep.printArray(r);
        System.out.println("the output should be [0,1,0,1,0,0,1,0]");
    }


    private void test2() {
        int[] cells = {0, 1, 0, 1, 1, 0, 0, 1};
        int N = 20;
        int[] r = prisonAfterNDays(cells, N);
        ep.printArray(r);
        System.out.println("the output should be [0,0,1,0,1,1,0,0]");
    }

    private void test3() {
        int[] cells = {0, 0, 1, 1, 1, 1, 0, 0};
        int N = 8;
        int[] r = prisonAfterNDays(cells, N);
        ep.printArray(r);
        System.out.println("the output should be [0,0,0,1,1,0,0,0]");
    }

    public static void main(String[] args) {
        PrisonCells p = new PrisonCells();
        p.test3();
    }
}
