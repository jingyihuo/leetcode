import java.util.List;

public class EasyPrint {

    public EasyPrint() {

    }

    public <E> void printArray(E[] array) {
        for (E e : array) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public void printArray(int[] array) {
        for (int e : array) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public void printArray(boolean[] array) {
        for (boolean e : array) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public void printArrays(int[][] arrays) {
        for (int[] array : arrays) {
            printArray(array);
        }
        System.out.println();
    }


    public void printArrays(boolean[][] arrays) {
        for (boolean[] array : arrays) {
            printArray(array);
        }
        System.out.println();
    }

    public void printArray(char[] array) {
        for (char e : array) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public void printArrays(char[][] arrays) {
        for (char[] array : arrays) {
            printArray(array);
        }
        System.out.println();
    }

    public void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public <E> void printList(List<E> list) {
        for (E e : list) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public <E> void printDoubleList(List<List<E>> dlist) {
        for (List<E> l : dlist) {
            printList(l);
        }
        System.out.println();
    }


}
