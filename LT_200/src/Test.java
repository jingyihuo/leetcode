import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {
    private EasyPrint ep = new EasyPrint();

    private void testStack() {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        s1.push(4);
        System.out.println(s1.pop());
        //System.out.println(s1.pop());

    }

    private void testInsertInList() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(2);

        ep.printList(list);

        list.add(1, 1);
        ep.printList(list);
    }

    private void testSubstring() {
        String s = "barfoo";
        String sub = s.substring(0, 3);
        System.out.println(sub);
    }

    private boolean check(String curr) {
        // "barfoo"
        String[] words = {"foo", "bar"};
        for (String wd : words) {
            int index = curr.indexOf(wd);
            //System.out.println(index);
            if (index == -1) {
                return false;
            } else {
                if (index == 0) {
                    curr = curr.substring(wd.length());
                } else {
                    curr = curr.substring(0, index) + curr.substring(index + wd.length());
                }
            }
            //System.out.println(curr);
        }
        //System.out.println(curr);
        return curr.length() == 0;
    }

    public static void main(String[] args) {
        Test p = new Test();
        //p.testStack();
        //p.testInsertInList();
        //p.testSubstring();
        //boolean ans = p.check("barfoo");
        try {
            System.out.println("A");
            badMethod();
            System.out.println("B");
        } catch (Exception ex) {

        } finally {
            
        }
    }

}
