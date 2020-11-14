import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class LogSystem {
    EasyPrint ep = new EasyPrint();
    TreeMap<Long, Integer> map;

    public LogSystem() {
        map = new TreeMap<>();
    }

    public void put(int id, String timestamp) {
        long key = convert(timestamp, 5, false);
        map.put(key, id);
        System.out.println("put -> key: " + key + " id: " + id);
    }

    private long convert(String timestamp, int index, boolean isEnd) {
        String[] times = timestamp.split(":");
        long res = 0L;
        int[] t = new int[6];
        for (int i = 0; i <= index; i++) {
            t[i] = Integer.parseInt(times[i]);
        }

        if (isEnd) t[index]++;
            
        res += (t[0] - 1999L) * 12 * 31 * 24 * 60 * 60;
        res += (t[1]) * 31 * 24 * 60 * 60;
        res += (t[2]) * 24 * 60 * 60;
        res += t[3] * 60 * 60;
        res += t[4] * 60;
        res += t[5];

        //ep.printArray(t);
        System.out.println(res);
        return res;
    }

    public List<Integer> retrieve(String start, String end, String granularity) {
        System.out.print("retrieve -> ");
        List<Integer> ids = new ArrayList<>();
        long s = calculate(start, granularity, false);
        long e = calculate(end, granularity, true);
        System.out.println(" s: " + s + " e: " + e);
        for (long key : map.tailMap(s).keySet()) {
            if (key >= s && key < e) {
                ids.add(map.get(key));
            }
        }
        return ids;
    }

    private long calculate(String time, String granularity, boolean isEnd) {
        int index = 0;
        switch (granularity) {
            case "Year":
                index = 0;
                break;
            case "Month":
                index = 1;
                break;
            case "Day":
                index = 2;
                break;
            case "Hour":
                index = 3;
                break;
            case "Minute":
                index = 4;
                break;
            case "Second":
                index = 5;
                break;
        }

        long key = convert(time, index, isEnd);
        return key;
    }

    public static void main(String[] args) {
        LogSystem p = new LogSystem();
        p.put(1, "2017:01:01:23:59:59");
        p.put(2, "2017:01:01:22:59:59");
        p.put(3, "2016:01:01:00:00:00");

        List<Integer> ans1 = p.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year");
        p.ep.printList(ans1);
        List<Integer> ans2 = p.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour");
        p.ep.printList(ans2);
    }
}
