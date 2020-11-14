import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class VerifyPreorderBST {
    EasyPrint ep = new EasyPrint();

    public boolean verifyPreorder(int[] preorder) {
        Deque<Integer> stack = new ArrayDeque();
        List<Integer> inorder = new ArrayList<>();

        for (int i : preorder) {
            while (!stack.isEmpty() && i > stack.peekLast()) {
                inorder.add(stack.removeLast());
            }
            stack.addLast(i);
        }
        ep.printList(inorder);
        return true;
    }

    public static void main(String[] args) {
        VerifyPreorderBST p = new VerifyPreorderBST();
        int[] pre = {5, 2, 6, 1, 3};
        p.verifyPreorder(pre);

    }
}
