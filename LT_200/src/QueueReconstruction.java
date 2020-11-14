import java.util.Arrays;

public class QueueReconstruction {
    EasyPrint ep = new EasyPrint();

    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        if (len <= 1) return people;

        int[][] ans = new int[len][2];
        //boolean[] occupied = new boolean[len];
        int empty = 0;

        Arrays.sort(people, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]));
        ep.printArrays(people);
        for (int[] p : people) {
            int height = p[0];
            int order = p[1];

            int place = empty + order;
            System.out.println(" height: " + height + " order: " + order + " place: " + place);
            ans[place][0] = height;
            ans[place][1] = order;

            if (place == empty) {
                empty++;
                while (empty < len && ans[empty][1] != 0) {
                    empty++;
                }
            }
            System.out.println("empty: " + empty);
        }
        ep.printArrays(ans);
        return ans;
    }

    public static void main(String[] arg) {
        QueueReconstruction p = new QueueReconstruction();
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        p.reconstructQueue(people);
    }
}
