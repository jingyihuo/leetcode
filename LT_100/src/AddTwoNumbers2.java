public class AddTwoNumbers2 {
    private EasyPrint ep = new EasyPrint();

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        ep.printListNode(l1);

        l2 = reverse(l2);
        ep.printListNode(l2);
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int n = (n1 + n2) % 10 + carry;
            carry = (n1 + n2) / 10;
            current.next = new ListNode(n);
            current = current.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // delete dummy
        current = dummy.next;
        dummy = null;

        return reverse(current);
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        AddTwoNumbers2 p = new AddTwoNumbers2();
        p.test1();
    }

    private void test1() {
        ListNode l1 = buildListNode1();
        ListNode l2 = buildListNode2();
        ListNode res = addTwoNumbers(l1, l2);
        System.out.println("the result is : ");
        ep.printListNode(res);
    }

    private ListNode buildListNode1() {
        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return n1;
    }

    private ListNode buildListNode2() {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(6);
        ListNode n3 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        return n1;
    }

}
