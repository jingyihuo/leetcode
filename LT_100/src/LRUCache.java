import java.util.HashMap;

public class LRUCache {
    // fields
    public LRUListNode head, tail;
    public HashMap<Integer, LRUListNode> map;
    public int capacity;

    // constructor
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new LRUListNode(-1, -1);
        tail = new LRUListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    // method 1
    public int get(int key) {
        if (map.containsKey(key)) {
            LRUListNode node = map.get(key);
            if (node.next != tail) {
                node.prev.next = node.next;
                node.next.prev = node.prev;

                node.prev = tail.prev;
                node.next = tail;
                tail.prev.next = node;
                tail.prev = node;
            }

            return node.value;
        } else {
            return -1;
        }
    }

    // method 2
    public void put(int key, int value) {
        // 这一步要记住，如果put的key已经存在，只能更新。
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        if (map.size() == capacity) {
            // 删除head后面的节点
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        LRUListNode insert = new LRUListNode(key, value);
        insert.next = tail;
        insert.prev = tail.prev;
        tail.prev.next = insert;
        tail.prev = insert;
        map.put(key, insert);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.get(2);
        cache.put(2, 6);
        cache.get(1);
        cache.put(1, 5);
        cache.put(1, 2);
        cache.get(1);
        cache.get(2);
    }
}

class LRUListNode {
    public int key, value;
    public LRUListNode prev, next;

    public LRUListNode(int key, int value) {
        this.value = value;
        this.key = key;
    }
}


