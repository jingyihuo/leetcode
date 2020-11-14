import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return 0;
            }
        });

        return new ListNode();
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int v) {
            val = v;
        }
    }
}
