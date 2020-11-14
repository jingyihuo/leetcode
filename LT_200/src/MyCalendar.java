import java.util.TreeMap;

public class MyCalendar {

    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (map.isEmpty()) {
            map.put(start, end);
            return true;
        }

        Integer prevStart = map.floorKey(start);
        Integer nextStart = map.ceilingKey(start);
        if (prevStart != null) {
            Integer prevEnd = map.get(prevStart);
            if (prevStart == start) return false;
            if (start < prevEnd) return false;
        }

        if (nextStart != null) {
            Integer nextEnd = map.get(nextStart);
            if (nextStart == start) return false;
            if (end > nextStart) return false;
        }

        map.put(start, end);

        return true;
    }
}
